package com.game.controller.command;

import com.game.domain.Game;
import com.game.domain.Statistics;
import com.game.service.GameService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PlayerHomeCommand implements Command {

    private GameService gameService;

    public PlayerHomeCommand(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Integer page;
        if (request.getParameter("page") == null) {
            page = 0;
        } else {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        List<Statistics> statistics = gameService.findAllStatistics(page, 3);
        List<Game> activeGames = gameService.findAllActiveGames();
        request.setAttribute("activeGames", activeGames);
        request.setAttribute("statistics", statistics);

        return "/WEB-INF/jsp/player/home.jsp";
    }
}
