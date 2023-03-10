package ru.gb.mark.lesson6.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        String pattern = httpReq.getHttpServletMapping().getPattern();

        if (pattern.equals("/hello")) {
            String login = httpReq.getParameter("login");
            String password = httpReq.getParameter("password");
            if (!(login.equals("log") && password.equals("pas"))) {
                httpResp.sendError(403, "Bad credentials");
            }
        }

        chain.doFilter(request, response);
    }
}
