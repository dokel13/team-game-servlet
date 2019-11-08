package com.game.controller.command;

import com.game.domain.Role;
import com.game.domain.User;
import com.game.exception.RegistrationRuntimeException;
import com.game.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {

    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        userService.findByLogin(login).ifPresent(user -> {
            throw new RegistrationRuntimeException("User already exists!");
        });
        User user = User.builder()
                .withLogin(login)
                .withPassword(password)
                .withRole(Role.PLAYER)
                .build();
        userService.register(user);

        request.getSession().setAttribute("role", user.getRole());
        request.getSession().setAttribute("login", user.getLogin());
        if (user.getRole() == Role.JUDGE) {
            return "redirect:/game/api/judge?" + request.getQueryString();
        } else {
            return "redirect:/game/api/player?" + request.getQueryString();
        }
    }
}
