package com.vietora.modules.auth.service.impl;

import com.vietora.common.exception.AppException;
import com.vietora.common.security.JwtUtil;
import com.vietora.common.util.EmailService;
import com.vietora.modules.auth.entity.*;
import com.vietora.modules.auth.enums.AccountStatus;
import com.vietora.modules.auth.enums.RoleType;
import com.vietora.modules.auth.payload.request.*;
import com.vietora.modules.auth.payload.response.AuthResponse;
import com.vietora.modules.auth.repository.*;
import com.vietora.modules.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final EmailVerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;

    @Value("${app.jwt.refresh-token-expiration-ms}")
    private long refreshTokenExpirationMs;

    @Override
    @Transactional
    public void register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Mật khẩu xác nhận không khớp");
        }
        if (accountRepository.existsByEmail(request.getEmail())) {
            throw new AppException(HttpStatus.CONFLICT, "Email đã được sử dụng");
        }
        if (accountRepository.existsByUsername(request.getUsername())) {
            throw new AppException(HttpStatus.CONFLICT, "Username đã được sử dụng");
        }

        Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
                .orElseThrow(() -> new AppException(HttpStatus.INTERNAL_SERVER_ERROR, "Role không tồn tại"));

        Account account = Account.builder()
                .fullName(request.getFullName())
                .username(request.getUsername())
                .email(request.getEmail())
                .dateOfBirth(request.getDateOfBirth())
                .password(passwordEncoder.encode(request.getPassword()))
                .status(AccountStatus.PENDING)
                .roles(Set.of(userRole))
                .build();
        accountRepository.save(account);

        String token = UUID.randomUUID().toString();
        verificationTokenRepository.save(EmailVerificationToken.builder()
                .token(token)
                .account(account)
                .expiryDate(LocalDateTime.now().plusHours(24))
                .build());

        emailService.sendVerificationEmail(account.getEmail(), account.getFullName(), token);
    }

    @Override
    @Transactional
    public void verifyEmail(String token) {
        EmailVerificationToken verificationToken = verificationTokenRepository.findByToken(token)
                .orElseThrow(() -> new AppException(HttpStatus.BAD_REQUEST, "Token xác thực không hợp lệ"));

        if (verificationToken.isExpired()) {
            throw new AppException(HttpStatus.BAD_REQUEST, "Token đã hết hạn, vui lòng đăng ký lại");
        }

        Account account = verificationToken.getAccount();
        account.setStatus(AccountStatus.ACTIVE);
        accountRepository.save(account);
        verificationTokenRepository.delete(verificationToken);
    }

    @Override
    @Transactional
    public AuthResponse login(LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        Account account = accountRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(HttpStatus.NOT_FOUND, "Tài khoản không tồn tại"));

        if (account.getStatus() == AccountStatus.PENDING) {
            throw new AppException(HttpStatus.FORBIDDEN, "Vui lòng xác thực email trước khi đăng nhập");
        }

        String accessToken  = jwtUtil.generateAccessToken(account.getEmail());
        String refreshToken = createRefreshToken(account);

        return buildAuthResponse(account, accessToken, refreshToken);
    }

    @Override
    @Transactional
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        RefreshToken stored = refreshTokenRepository.findByToken(request.getRefreshToken())
                .orElseThrow(() -> new AppException(HttpStatus.UNAUTHORIZED, "Refresh token không hợp lệ"));

        if (stored.getExpiryDate().isBefore(LocalDateTime.now())) {
            refreshTokenRepository.delete(stored);
            throw new AppException(HttpStatus.UNAUTHORIZED, "Refresh token đã hết hạn, vui lòng đăng nhập lại");
        }

        Account account     = stored.getAccount();
        String accessToken  = jwtUtil.generateAccessToken(account.getEmail());
        String newRefresh   = createRefreshToken(account);
        refreshTokenRepository.delete(stored);

        return buildAuthResponse(account, accessToken, newRefresh);
    }

    @Override
    @Transactional
    public void logout(String refreshToken) {
        refreshTokenRepository.findByToken(refreshToken)
                .ifPresent(refreshTokenRepository::delete);
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    private String createRefreshToken(Account account) {
        refreshTokenRepository.deleteByAccount(account);
        RefreshToken token = RefreshToken.builder()
                .token(UUID.randomUUID().toString())
                .account(account)
                .expiryDate(LocalDateTime.now().plusSeconds(refreshTokenExpirationMs / 1000))
                .build();
        return refreshTokenRepository.save(token).getToken();
    }

    private AuthResponse buildAuthResponse(Account account, String accessToken, String refreshToken) {
        Set<String> roles = account.getRoles().stream()
                .map(r -> r.getName().name())
                .collect(Collectors.toSet());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .id(account.getId().toString())
                .fullName(account.getFullName())
                .username(account.getUsername())
                .email(account.getEmail())
                .roles(roles)
                .build();
    }
}
