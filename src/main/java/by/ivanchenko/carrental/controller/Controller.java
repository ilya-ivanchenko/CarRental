package by.ivanchenko.carrental.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
        commandName = request.getParameter("command");
        command = provider.getCommand(commandName);
        commandPage = command.execute(request, response);
        request.getRequestDispatcher(commandPage).forward(request, response);  //check;
    }

}
