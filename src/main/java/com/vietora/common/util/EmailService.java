package com.vietora.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String from;

    @Value("${app.base-url}")
    private String baseUrl;

    @Async
    public void sendVerificationEmail(String toEmail, String fullName, String token) {
        String link = baseUrl + "/verify-email?token=" + token;
        String body = "Xin chào " + fullName + ",\n\n"
                + "Vui lòng bấm vào link bên dưới để xác thực tài khoản Vietora của bạn:\n\n"
                + link + "\n\n"
                + "Link có hiệu lực trong 24 giờ.\n\n"
                + "Vietora Team";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toEmail);
        message.setSubject("[Vietora] Xác thực tài khoản");
        message.setText(body);
        mailSender.send(message);
    }
}
