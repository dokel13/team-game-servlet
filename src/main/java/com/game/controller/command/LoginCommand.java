package com.game.controller.command;

import com.game.domain.Role;
import com.game.domain.User;
import com.game.service.UserService;
import com.game.util.EncryptionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.getUserByLogin(login).orElseThrow(() -> new RuntimeException("User does not exist!"));
        if (EncryptionUtils.encrypt(password).equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("role", user.getRole());
            if (user.getRole() == Role.JUDGE) {
                return "redirect:/game/api/judge";
            } else {
                return "redirect:/game/api/player";
            }
        } else {
            return "redirect:/game/api/home";
        }
    }
}
