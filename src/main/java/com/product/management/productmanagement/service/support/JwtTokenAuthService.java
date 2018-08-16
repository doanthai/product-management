package com.product.management.productmanagement.service.support;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.ClaimsHolder;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Header;
import com.product.management.productmanagement.dto.request.CurrentUser;
import com.product.management.productmanagement.entity.User;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.NotTokenPmException;
import com.product.management.productmanagement.service.ITokenAuthService;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;


public class JwtTokenAuthService implements ITokenAuthService<User> {

    private final String  HEADER_AUTHORIZATION = "Authorization";
    @Value("${spring.jwt.secret}")
    private String secret;
    @Value("${spring.jwt.prefix}")
    private String prefix;
    private Algorithm algorithm;

    public JwtTokenAuthService() {
        algorithm = Algorithm.HMAC256(secret);
    }

    @Override
    public String encodeToken(User object) {
        return JWT.create()
                .withClaim("username",object.getUsername())
                .withClaim("displayName",object.getDisplayName())
                .withClaim("address",object.getAddress())
                .withClaim("avatar",object.getAvatar())
                .withClaim("birthday",object.getBirthday())
                .withClaim("email",object.getEmail())
                .withClaim("phone",object.getPhone())
                .withClaim("role",object.getRole())
                .withClaim("gender",object.getGender())
                .sign(algorithm);
    }

    @Override
    public boolean verifyToken(String token) {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        return true;
    }

    @Override
    public User decodeToken(String token) throws NotTokenPmException {
        isValidToken(token);
        DecodedJWT jwt = JWT.decode(token);
        User user = new User();
        user.setUsername(jwt.getClaim("username").asString());
        user.setDisplayName(jwt.getClaim("displayName").asString());
        user.setAddress(jwt.getClaim("address").asString());
        user.setAvatar(jwt.getClaim("avatar").asString());
        user.setBirthday(Timestamp.valueOf(jwt.getClaim("birthday").asString()));
        user.setEmail(jwt.getClaim("email").asString());
        user.setPhone(jwt.getClaim("phone").asString());
        user.setRole(jwt.getClaim("role").asString());
        user.setGender(jwt.getClaim("gender").asInt());
        return user;
    }

    private void isValidToken(String token) throws NotTokenPmException {
        if(token == null || token.equals(""))
            throw new NotTokenPmException(ExceptionCode.TOKEN_EMPTY.getCode(), ExceptionCode.TOKEN_EMPTY.getMessage());
    }
}
