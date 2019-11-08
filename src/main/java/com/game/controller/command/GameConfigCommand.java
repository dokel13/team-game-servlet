package com.game.controller.command;

import javax.servlet.http.HttpServletRequest;

public class GameConfigCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/jsp/player/game.jsp";
    }
}
