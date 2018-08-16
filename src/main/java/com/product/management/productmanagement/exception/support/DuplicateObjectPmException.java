package com.product.management.productmanagement.exception.support;

import com.product.management.productmanagement.exception.PmException;

public class DuplicateObjectPmException extends PmException {
    public DuplicateObjectPmException(String code, String message) {
        super(code, message);
    }
}
