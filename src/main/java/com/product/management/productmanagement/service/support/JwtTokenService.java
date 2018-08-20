package com.product.management.productmanagement.service.support;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.product.management.productmanagement.dto.request.CurrentUser;
import com.product.management.productmanagement.entity.User;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.NotTokenPmException;
import com.product.management.productmanagement.service.ITokenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class JwtTokenService implements ITokenService<User, CurrentUser> {


    @Value("${spring.jwt.secret}")
    private String secret;
    @Value("${spring.jwt.prefix}")
    private String prefix;
    @Value("${spring.jwt.id}")
    private String jwtId;
    @Value("${spring.jwt.issuer}")
    private String jwtIssuer;
    private Algorithm algorithm;

    public JwtTokenService() {
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
                .withJWTId(jwtId)
                .withIssuer(jwtIssuer)
                .sign(algorithm);
    }

    @Override
    public boolean verifyTokenClaim(User user, CurrentUser currentUser) {
        return checkUser(user,currentUser);
    }

    private boolean checkUser(User user, CurrentUser currentUser) {
        if(user == null) throw new NullPointerException("User is null");
        if(currentUser == null) throw new NullPointerException("User is null");
        ModelMapper mapper = new ModelMapper();
        CurrentUser mapUser = mapper.map(user, CurrentUser.class);
        return mapUser.equals(currentUser);
    }

    @Override
    public CurrentUser decodeToken(String token) throws NotTokenPmException {
        isValidToken(token);
        JWTVerifier verifier = JWT.require(algorithm)
                .withJWTId(jwtId)
                .withIssuer(jwtIssuer)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return CurrentUser.builder()
                .username(jwt.getClaim("username").asString())
                .displayName(jwt.getClaim("displayName").asString())
                .address(jwt.getClaim("address").asString())
                .avatar(jwt.getClaim("avatar").asString())
                .birthday(Timestamp.valueOf(jwt.getClaim("birthday").asString()))
                .email(jwt.getClaim("email").asString())
                .phone(jwt.getClaim("phone").asString())
                .role(jwt.getClaim("role").asString())
                .gender(jwt.getClaim("gender").asInt())
                .build();
    }

    private void isValidToken(String token) throws NotTokenPmException {
        if(token == null || token.equals(""))
            throw new NotTokenPmException(ExceptionCode.TOKEN_EMPTY.getCode(), ExceptionCode.TOKEN_EMPTY.getMessage());
    }
}
