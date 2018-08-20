package com.product.management.productmanagement.security;

import com.product.management.productmanagement.entity.User;
import com.product.management.productmanagement.exception.support.LoginPmException;
import com.product.management.productmanagement.exception.support.NotFoundObjectPmExcpetion;
import com.product.management.productmanagement.service.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PmAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("userService")
    private IAbstractService<User, String> abstractService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName().trim();
        String password = authentication.getCredentials().toString().trim();
        User user = null;
        try {
            user = abstractService.getOneByKey(username);
        } catch (NotFoundObjectPmExcpetion e) {
            throw new LoginPmException(e.getCode(),e.getMessage());
        }
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
        return new UsernamePasswordAuthenticationToken(username,password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
