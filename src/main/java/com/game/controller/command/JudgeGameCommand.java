package com.game.controller.command;

import com.game.domain.Game;
import com.game.domain.User;
import com.game.service.GameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class JudgeGameCommand implements Command {

    private GameService gameService;

    public JudgeGameCommand(GameService gameService) {
        this.gameService = gameService;
    }
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        Game game = Game.builder()
                .withJudge(login)
                .withActivity(true)
                .build();
        gameService.create(game);
        return "/WEB-INF/jsp/judge/game.jsp";
    }
}
