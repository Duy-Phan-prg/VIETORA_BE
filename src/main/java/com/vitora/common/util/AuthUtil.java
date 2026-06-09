package com.vitora.common.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public static String currentEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
