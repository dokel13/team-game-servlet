package com.game.controller.command;

import com.game.domain.Role;
import com.game.domain.User;
import com.game.exception.LoginRuntimeException;
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

        User user = userService.findByLogin(login).orElseThrow(() -> new LoginRuntimeException("User doesn't exist!"));
        if (EncryptionUtils.encrypt(password).equals(user.getPassword())) {
            request.getSession().setAttribute("role", user.getRole());
            request.getSession().setAttribute("login", user.getLogin());
            if (user.getRole() == Role.JUDGE) {
                return "redirect:/game/api/judge?" + request.getQueryString();
            } else {
                return "redirect:/game/api/player?" + request.getQueryString();
            }
        } else {
            return "redirect:/game/api/home?" + request.getQueryString();
        }
    }
}
