package com.game.controller.command;

import com.game.domain.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
//        Locale locale = (Locale) session.getAttribute("locale");
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("application", locale);
//        request.setAttribute("enter_game", resourceBundle.getString("enter_game"));
//        request.setAttribute("register_enter", resourceBundle.getString("register_enter"));
//        request.setAttribute("your_login", resourceBundle.getString("your_login"));
//        request.setAttribute("your_password", resourceBundle.getString("your_password"));
//        request.setAttribute("new_login", resourceBundle.getString("new_login"));
//        request.setAttribute("new_password", resourceBundle.getString("new_password"));
//        request.setAttribute("login", resourceBundle.getString("login"));
//        request.setAttribute("register", resourceBundle.getString("register"));

        Role role = (Role) request.getSession().getAttribute("role");

        if (role == Role.JUDGE) {
            return "redirect:/game/api/judge";
        } else if (role == Role.PLAYER) {
            return "redirect:/game/api/player";
        } else {
            return "/WEB-INF/jsp/home.jsp";
        }
    }
}
