package com.game.controller.command;

import javax.servlet.http.HttpServletRequest;

public class PlayerHomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/jsp/player/home.jsp";
    }
}
