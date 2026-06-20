package com.vietora.common.security;

import com.vietora.modules.auth.entity.Account;
import com.vietora.modules.auth.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found: " + email));

        var authorities = account.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getName().name()))
                .collect(Collectors.toSet());

        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(account.getStatus().name().equals("BANNED"))
                .credentialsExpired(false)
                .disabled(account.getStatus().name().equals("PENDING"))
                .build();
    }
}
