package com.neuedu.JavaItems.until;

import org.omg.CORBA.TIMEOUT;

import java.sql.Date;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.SimpleFormatter;

public class Getid {

//将String类型转为Date类型

    public static Date changeStrtoDate(String str)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        try {
            java.util.Date parse = sdf.parse(str);
            date = new Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


//获取随机数ID
    public static String getProId()
    {
            Random random = new Random();
            int i = random.nextInt(100);
            String str = String.valueOf(System.currentTimeMillis())+"_";
            if (i<10)
            {
            str += "0"+i;
            }

            return str +=+i;
    }

//获取当前日期
    public static Date getDate()
    {
        Date date = new Date(new java.util.Date().getTime());
        return date;
    }

    public static void main(String[] args) {
        Date date = Getid.getDate();
        System.out.print(date);
    }
}
