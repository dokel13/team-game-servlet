package com.game.controller.command;

import com.game.domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("role");
        if (role == Role.JUDGE) {
            return "redirect:/game/api/judge";
        } else if (role == Role.PLAYER) {
            return "redirect:/game/api/player";
        } else {
            return "/WEB-INF/jsp/home.jsp";
        }
    }
}
