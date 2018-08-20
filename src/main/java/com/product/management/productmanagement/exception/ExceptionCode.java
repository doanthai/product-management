package com.product.management.productmanagement.exception;


public enum ExceptionCode {
    //1xx
    NOT_FOUND_PRODUCT_BY_ID("000","NOT FOUND PRODUCT BY ID"),
    PRODUCT_ID_EXISTS("001","PRODUCT IS IS EXISTS"),
    PRODUCT_NAME_EXISTS("002","PRODUCT NAME IS EXISTS"),
    //2xx
    NOT_FOUND_USER_BY_ID("100","NOT FOUND USER BY ID"),
    EMAIL_EXISTS("101","EMAIL IS IS EXISTS"),
    USER_NAME_EXISTS("102","USER NAME IS EXISTS"),

    TOKEN_EMPTY("900","TOKEN IS NULL OR EMPTY"),
    TOKEN_INVALID("901","TOKEN IS INVALID"),
    LOGIN_FAILED("902","LOGIN IS FAILED"),
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
