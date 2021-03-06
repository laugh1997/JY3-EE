package com.neuedu.JavaItems.controller;

import com.neuedu.JavaItems.Dao.UserDao;
import com.neuedu.JavaItems.Dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String use = request.getParameter("Use");
        String psd = request.getParameter("Psd");
        boolean b = ud.userLogin(use, psd);
        if (b ==true)
        {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("fail.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
