package com.game.controller.command;

import javax.servlet.http.HttpServletRequest;

public class JudgeHomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/jsp/judge/home.jsp";
    }
}
