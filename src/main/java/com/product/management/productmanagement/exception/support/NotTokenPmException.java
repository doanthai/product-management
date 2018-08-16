package com.product.management.productmanagement.exception.support;

import com.product.management.productmanagement.exception.PmException;

public class NotTokenPmException extends PmException {
    public NotTokenPmException(String code, String message) {
        super(code, message);
    }
}
