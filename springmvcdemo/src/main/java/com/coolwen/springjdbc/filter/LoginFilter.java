package com.coolwen.springjdbc.filter;


import com.coolwen.springjdbc.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CoolWen
 * @version 2018-10-11 7:52
 */

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsq = (HttpServletRequest) req;
        User u = (User) hsq.getSession().getAttribute("loginUser");
        if (u == null) {
            ((HttpServletResponse) resp).sendRedirect(hsq.getContextPath() + "/login");
        }
        chain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
