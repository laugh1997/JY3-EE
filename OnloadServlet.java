package com.neuedu.JavaItems.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@WebServlet(name = "OnloadServlet",urlPatterns = "/onload.do")
@MultipartConfig
public class OnloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part file1 = request.getPart("file1");
//拿到上传文件的名字
        String submittedFileName = file1.getSubmittedFileName();
        InputStream is = file1.getInputStream();
//创建uuid随机生成64位码
        UUID uuid = UUID.randomUUID();

        String str = submittedFileName;
        OutputStream os = new FileOutputStream("D:\\img\\"+uuid+str);
        int buffer = 0;
        byte[] bs = new byte[1024];
        while ((buffer=is.read(bs))!=-1){
           os.write(bs,0,buffer);
        }
        os.close();
        is.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
