package com.product.management.productmanagement.exception.support;

import org.springframework.security.core.AuthenticationException;

public class LoginPmException extends AuthenticationException {
    private String code;

    public LoginPmException(String code, String message) {
        super(message);
        this.code = code;
    }
}
