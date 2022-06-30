package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPool;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@WebServlet("/registration")
public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            req.setAttribute("",...);
//            req.getSession().setAttribute("",...);
//            req.getServletContext().setAttribute("", ....);
        //  и так  и так можно
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        if ("registration".equals((req.getParameter("command")))) {
            req.getRequestDispatcher("usebean.jsp").forward(req, resp);
            System.out.println("forward ok");
            RegistrationCommand registrationCommand = new RegistrationCommand();
            registrationCommand.execute(req,resp);
        }
        System.out.println("рег ОК");
    }
}
