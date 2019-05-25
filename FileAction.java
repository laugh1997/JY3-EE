package com.neuedu.JavaItems.until;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class FileAction {


    public static String onloadFile(Part part)
    {
//拿到上传文件的名字
        String submittedFileName = part.getSubmittedFileName();
//创建uuid随机生成64位码
        UUID uuid = UUID.randomUUID();

        InputStream is = null;
        OutputStream os = null;
        String str = submittedFileName;
        String name = uuid+str;
        try {
            is = part.getInputStream();
            os = new FileOutputStream("D:\\img\\"+name);
            int buffer = 0;
            byte[] bs = new byte[1024];
            while ((buffer=is.read(bs))!=-1){
                os.write(bs,0,buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    return  name;

    }

}
