package com.product.management.productmanagement.security;

import com.product.management.productmanagement.entity.User;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.LoginPmException;
import com.product.management.productmanagement.service.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


/**
 * Filter do action login of user
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {


    public JwtLoginFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    public JwtLoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    JwtLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        checkLoginDataFromRequest(username,password);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(username,password,Collections.emptyList()));
    }

    private void checkLoginDataFromRequest(String username, String password) throws LoginPmException {
        if(username == null || username.isEmpty())
            throw new LoginPmException(ExceptionCode.LOGIN_FAILED.getCode(),"Username is empty");
        if(password == null || password.isEmpty())
            throw new LoginPmException(ExceptionCode.LOGIN_FAILED.getCode(),"Username is empty");
    }
}
