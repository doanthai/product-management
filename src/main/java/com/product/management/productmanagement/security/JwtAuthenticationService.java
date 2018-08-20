package com.product.management.productmanagement.security;

import com.product.management.productmanagement.dto.request.CurrentUser;
import com.product.management.productmanagement.entity.User;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.NotFoundObjectPmExcpetion;
import com.product.management.productmanagement.exception.support.NotTokenPmException;
import com.product.management.productmanagement.exception.support.TokenInvalidPmException;
import com.product.management.productmanagement.service.IAbstractService;
import com.product.management.productmanagement.service.ITokenService;
import com.product.management.productmanagement.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

public class JwtAuthenticationService {

    @Autowired
    @Qualifier("jwtTokenService")
    private static ITokenService<User, CurrentUser> abstractService;

    @Autowired
    @Qualifier("userService")
    private static IAbstractService<User, String> userService;

    static Authentication getAuthentication(HttpServletRequest request) throws TokenInvalidPmException {
        try {
            String token = request.getHeader(Constants.HEADER_AUTHORIZATION);
            CurrentUser currentUser = abstractService.decodeToken(token);
            User user = userService.getOneByKey(currentUser.getUsername());
            abstractService.verifyTokenClaim(user,currentUser);
            List<GrantedAuthority> authorityList = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
            return new UsernamePasswordAuthenticationToken(currentUser,null,authorityList);
        } catch (NotTokenPmException | NotFoundObjectPmExcpetion e) {
            throw new TokenInvalidPmException(ExceptionCode.TOKEN_INVALID.getCode(),ExceptionCode.TOKEN_INVALID.getMessage());
        }
    }

}
