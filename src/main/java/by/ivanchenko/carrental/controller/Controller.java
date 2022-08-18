package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class Controller extends HttpServlet {
    private final CommandProvider provider = new CommandProvider();
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
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
        try {
            commandName = request.getParameter(COMMAND);
            command = provider.getCommand(commandName);
            commandPage = command.execute(request, response);
            request.getRequestDispatcher(commandPage).forward(request, response);



            LOGGER.info("Controller works");
        } catch (ServletException | IOException e) {
            LOGGER.error("Controller method error", e);
        }

    }

}
