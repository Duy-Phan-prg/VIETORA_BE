package com.vietora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VietoraApplication {
    public static void main(String[] args) {
        SpringApplication.run(VietoraApplication.class, args);
    }
}
