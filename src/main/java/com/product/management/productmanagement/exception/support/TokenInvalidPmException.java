package com.product.management.productmanagement.exception.support;

import com.product.management.productmanagement.exception.PmException;

public class TokenInvalidPmException extends PmException {
    public TokenInvalidPmException(String code, String message) {
        super(code, message);
    }
}
