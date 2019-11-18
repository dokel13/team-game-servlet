package com.game.controller;

import com.game.controller.command.*;
import com.game.dao.*;
import com.game.service.GameService;
import com.game.service.GameServiceImpl;
import com.game.service.UserService;
import com.game.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GlobalServlet extends HttpServlet {

    private static final Map<String, Command> COMMANDS = new HashMap<>();

    @Override
    public void init() throws ServletException {
        UserDao userDao = new UserDaoImpl();
        GameDao gameDao = new GameDaoImpl();
        StatisticsDao statisticsDao = new StatisticsDaoImpl();
        QuestionDao questionDao = new QuestionDaoImpl();
        UserService userService = new UserServiceImpl(userDao);
        GameService gameService = new GameServiceImpl(gameDao, statisticsDao, questionDao);

        COMMANDS.put("home", new HomeCommand());
        COMMANDS.put("player", new PlayerHomeCommand(gameService));
        COMMANDS.put("judge", new JudgeHomeCommand(gameService));
        COMMANDS.put("login", new LoginCommand(userService));
        COMMANDS.put("register", new RegistrationCommand(userService));
        COMMANDS.put("logout", new LogoutCommand());
        COMMANDS.put("player/game", new PlayerGameCommand());
        COMMANDS.put("judge/game", new JudgeGameCommand(gameService));
        COMMANDS.put("error", new ErrorCommand());
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        path = path.replaceAll(".*game/api/", "");
        Command command = COMMANDS.get(path);
        String page = command.execute(request);

        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
