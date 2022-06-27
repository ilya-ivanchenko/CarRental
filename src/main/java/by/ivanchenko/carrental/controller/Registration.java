package by.ivanchenko.carrental.controller;

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
//                req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html");
//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("Ola");
//        req.setAttribute("list", list);
//        req.getRequestDispatcher("usebean.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        if ("registration".equals((req.getParameter("command")))) {
            req.getRequestDispatcher("usebean.jsp").forward(req, resp);
        }
    }
}
