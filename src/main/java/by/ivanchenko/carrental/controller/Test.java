package by.ivanchenko.carrental.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/mypage")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).setAttribute("local", req.getParameter("local"));
        req.getRequestDispatcher("test.jsp").forward(req,resp);


        System.out.println("req.attr - " + req.getAttribute("local"));
        System.out.println("session.attr - " + req.getSession().getAttribute("local"));
        System.out.println("req.param - " + req.getParameter("local"));
        System.out.println("---------------");
    }
}
