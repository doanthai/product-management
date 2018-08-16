package com.product.management.productmanagement.exception.support;

import com.product.management.productmanagement.exception.PmException;

public class NotFoundObjectPmExcpetion extends PmException {
    public NotFoundObjectPmExcpetion(String code, String message) {
        super(code, message);
    }
}
