package com.game.controller.filter;

import com.game.domain.Role;
import com.game.exception.AccessForbiddenRuntimeException;

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
        rolesAllowedURIs.put("/game/api/player/game", Role.PLAYER);
        rolesAllowedURIs.put("/game/api/judge/game", Role.JUDGE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        Role role = (Role) httpRequest.getSession().getAttribute("role");
        Role allowedRole = rolesAllowedURIs.get(httpRequest.getRequestURI());
        if (allowedRole == null || allowedRole == role) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            throw new AccessForbiddenRuntimeException("Authorisation access exception!");
        }
    }

    @Override
    public void destroy() {

    }
}
