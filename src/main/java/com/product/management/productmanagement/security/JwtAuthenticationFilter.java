package com.product.management.productmanagement.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.management.productmanagement.dto.response.Result;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.NotFoundObjectPmExcpetion;
import com.product.management.productmanagement.exception.support.NotTokenPmException;
import com.product.management.productmanagement.exception.support.TokenInvalidPmException;
import com.product.management.productmanagement.util.Constants;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        Result result = null;
        try {
            if(!Constants.API_NOT_REQUIRED_AUTHEN.contains(((HttpServletRequest)request).getRequestURI())) {
                Authentication authentication = JwtAuthenticationService.getAuthentication((HttpServletRequest) request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request,response);
        } catch (TokenInvalidPmException e) {
            e.printStackTrace();
            result = new Result<>(e.getCode(),e.getMessage(),null);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(ExceptionCode.FATAL_ERROR.getCode(),e.getMessage(),null);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(result));
    }
}