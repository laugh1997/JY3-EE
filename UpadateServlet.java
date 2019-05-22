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

@WebServlet(name = "UpadateServlet",urlPatterns = "/update.do")
public class UpadateServlet extends HttpServlet {
    private Userdao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id1 = Integer.valueOf(request.getParameter("id1"));
        String name1 = request.getParameter("name1");
        String psw1 = request.getParameter("psw1");
        ud.update(new User(id1,name1,psw1));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
