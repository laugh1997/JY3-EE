package com.neuedu.JavaItems.controller;

import com.neuedu.JavaItems.Dao.UserDao;
import com.neuedu.JavaItems.Dao.UserDaoImpl;
import com.neuedu.JavaItems.until.Getid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/reg.do")
public class RegisterServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
      ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("UserName");
        String psw = request.getParameter("PassWord");

        ud.regOneAccount(username,psw,Getid.getDate());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
