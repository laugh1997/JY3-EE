package com.neuedu.controller;

import com.neuedu.dao.UserDaoImpl;
import com.neuedu.dao.Userdao;
import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update.do")
public class UpdateServlet extends HttpServlet {
    private Userdao ud;
    @Override
    public void init() throws ServletException {
       ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String pasd = request.getParameter("pasd");
        ud.update(new User(id,username,pasd));
        response.sendRedirect("user.do");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
