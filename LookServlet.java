package com.neuedu.JavaItems.controller;

import com.neuedu.JavaItems.Dao.ProInterace;
import com.neuedu.JavaItems.Dao.ProductImpl;
import com.neuedu.JavaItems.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LookServlet",urlPatterns = "/look.do")
public class LookServlet extends HttpServlet {

    private ProInterace pc;

    @Override
    public void init() throws ServletException {
        pc = new ProductImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> allPro = pc.getAllPro();
        request.setAttribute("product",allPro);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
