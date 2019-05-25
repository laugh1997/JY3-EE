package com.neuedu.JavaItems.controller;

import com.neuedu.JavaItems.Dao.ProInterace;
import com.neuedu.JavaItems.Dao.ProductImpl;
import com.neuedu.JavaItems.pojo.Product;
import com.neuedu.JavaItems.until.FileAction;
import com.neuedu.JavaItems.until.Getid;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "addOneProServlet",urlPatterns = "/add.do")
@MultipartConfig
public class addOneProServlet extends HttpServlet {
    private ProInterace pc;
    @Override
    public void init() throws ServletException {
       pc = new ProductImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String proName = request.getParameter("proName");

        String proPrice = request.getParameter("proPrice");
        double proPrice2 = Double.parseDouble(proPrice);
//把图片存到服务器
        Part proImage = request.getPart("proImage");
        String realFileName = FileAction.onloadFile(proImage);

        String proDes = request.getParameter("proDes");

        String proStock = request.getParameter("proStock");
        int proStock2 = Integer.parseInt(proStock);

        String proDate = request.getParameter("proDate");
        Date date = Getid.changeStrtoDate(proDate);

        String proCate = request.getParameter("proCate");
        Short  proCate2 = Short.parseShort(proCate);

        String proFactory = request.getParameter("proFactory");

        String proId = Getid.getProId();


        Product product = new Product(proId,proName,proPrice2,realFileName,proDes,proStock2,date,proCate2,proFactory);
        pc.addOnePro(product);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
