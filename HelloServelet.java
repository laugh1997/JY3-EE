package com.neuedu.servelet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServelet",urlPatterns = "/Hello.do")
public class HelloServelet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//接收请求
        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        ud.regsiter(user,psw);
        request.getRequestDispatcher("login.jsp").forward(request,response);
//        response.getWriter().write("<h1>hello</h1>");
    }
}
