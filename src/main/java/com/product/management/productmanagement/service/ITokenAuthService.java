package com.product.management.productmanagement.service;

import com.product.management.productmanagement.exception.support.NotTokenPmException;

public interface ITokenAuthService<U> {
    String encodeToken(U object);
    boolean verifyToken(String token);
    U decodeToken(String token) throws NotTokenPmException;
}
