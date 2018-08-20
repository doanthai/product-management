package com.product.management.productmanagement.service;

import com.product.management.productmanagement.exception.support.NotTokenPmException;

public interface ITokenService<U, CU> {
    String encodeToken(U object);
    boolean verifyTokenClaim(U user, CU currentUser);
    CU decodeToken(String token) throws NotTokenPmException;
}
