package com.product.management.productmanagement.security;

import com.product.management.productmanagement.util.Constants;
import org.springframework.security.core.Authentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(Constants.API_NOT_REQUIRED_AUTHEN.contains(((HttpServletRequest)servletRequest).getRequestURI()))
            filterChain.doFilter(servletRequest,servletResponse);
//        else {
//            Authentication authentication = TokenAuthenticationService
//                    .getAuthentication((HttpServletRequest)servletRequest);
//        }
    }

    @Override
    public void destroy() {}
}
