package com.game.controller;

import com.game.controller.command.*;
import com.game.dao.UserDao;
import com.game.dao.UserDaoImpl;
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

    private static Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDao);

        commands.put("home", new HomeCommand());
        commands.put("player", new PlayerHomeCommand());
        commands.put("judge", new JudgeHomeCommand());
        commands.put("login", new LoginCommand(userService));
        commands.put("register", new RegistrationCommand(userService));
        commands.put("logout", new LogoutCommand());
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        path = path.replaceAll(".*game/api/", "");
        Command command = commands.get(path);
        String page = command.execute(request);

        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
