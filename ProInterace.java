package com.neuedu.JavaItems.Dao;

import com.neuedu.JavaItems.pojo.Product;

import javax.servlet.http.Part;
import java.util.List;

public interface ProInterace {

//添加商品
    void addOnePro(Product pro);

//删除商品
    void delOnePro(String pro_id);

//查询商品
    List<Product> getAllPro();



}
