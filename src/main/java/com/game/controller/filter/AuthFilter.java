package com.game.controller.filter;

import com.game.domain.Role;
import com.game.exception.AccessForbiddenException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthFilter implements Filter {

    private static Map<String, Role> rolesAllowedURIs = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) {
        rolesAllowedURIs.put("/game/api/player", Role.PLAYER);
        rolesAllowedURIs.put("/game/api/judge", Role.JUDGE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        Role role = (Role) session.getAttribute("role");
        Role allowedRole = rolesAllowedURIs.get(httpRequest.getRequestURI());
        if (allowedRole == null || allowedRole == role) {
            filterChain.doFilter(request, response);
        } else {
            throw new AccessForbiddenException();
        }
    }

    @Override
    public void destroy() {

    }
}
