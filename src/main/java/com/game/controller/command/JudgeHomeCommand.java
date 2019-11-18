package com.game.controller.command;

import com.game.domain.Question;
import com.game.service.GameService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class JudgeHomeCommand implements Command {

    GameService gameService;

    public JudgeHomeCommand(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Question> questions = gameService.findRandomQuestions(6);
        request.setAttribute("questions", questions);

        return "/WEB-INF/jsp/judge/home.jsp";
    }
}
