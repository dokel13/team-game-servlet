package com.game.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();

        return "redirect:/game/api/home";
    }
}
