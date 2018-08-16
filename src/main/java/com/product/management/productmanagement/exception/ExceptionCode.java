package com.product.management.productmanagement.exception;


public enum ExceptionCode {
    //1xx
    NOT_FOUND_PRODUCT_BY_ID("000","NOT FOUND PRODUCT BY ID"),
    PRODUCT_ID_EXISTS("001","PRODUCT IS IS EXISTS"),
    PRODUCT_NAME_EXISTS("002","PRODUCT NAME IS EXISTS"),

    TOKEN_EMPTY("900","TOKEN IS NULL OR EMPTY"),
    FATAL_ERROR("999","FATAL ERROR");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
