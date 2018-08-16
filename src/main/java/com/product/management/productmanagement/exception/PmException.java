package com.product.management.productmanagement.exception;

public class PmException extends Exception {
    private String code;

    public PmException(String code,String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
