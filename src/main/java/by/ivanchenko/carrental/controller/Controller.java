package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class Controller extends HttpServlet {
    private final CommandProvider provider = new CommandProvider();
    Command command;
    String commandName;
    String commandPage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executeTask(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executeTask(req, resp);
    }

    private void executeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        commandName = request.getParameter(COMMAND);
        command = provider.getCommand(commandName);
        commandPage = command.execute(request, response);
       // request.getSession(true).setAttribute("local", request.getParameter("local"));
        request.getRequestDispatcher(commandPage).forward(request, response);
    }

}
