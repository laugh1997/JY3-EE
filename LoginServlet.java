package com.neuedu.servelet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
       ud = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String psw =  request.getParameter("psw");
        User login = ud.login(new User(user, psw));
        if ( null != login){
            request.setAttribute("user",user);
            request.getRequestDispatcher("Success.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("failed.jsp").forward(request,response);
        }
    }
}
