package com.neuedu.JavaItems.pojo;

import java.sql.Date;

public class Product {


    public Product(String pro_id, String pro_name, Double pro_price, String pro_image, String pro_des, Integer pro_stock, Date pro_date, Short pro_cate_id, String pro_factory) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_image = pro_image;
        this.pro_des = pro_des;
        this.pro_stock = pro_stock;
        this.pro_date = pro_date;
        this.pro_cate_id = pro_cate_id;
        this.pro_factory = pro_factory;
    }

    public Product()
    {

    }


    private String pro_id;

    private String pro_name;

    private Double pro_price;

    private String pro_image;

    private String pro_des;

    private Integer pro_stock;

    private Date pro_date;

    private Short pro_cate_id;

    private String pro_factory;


    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Double getPro_price() {
        return pro_price;
    }

    public void setPro_price(Double pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_image() {
        return pro_image;
    }

    public void setPro_image(String pro_image) {
        this.pro_image = pro_image;
    }

    public String getPro_des() {
        return pro_des;
    }

    public void setPro_des(String pro_des) {
        this.pro_des = pro_des;
    }

    public Integer getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(Integer pro_stock) {
        this.pro_stock = pro_stock;
    }

    public Date getPro_date() {
        return pro_date;
    }

    public void setPro_date(Date pro_date) {
        this.pro_date = pro_date;
    }

    public Short getPro_cate_id() {
        return pro_cate_id;
    }

    public void setPro_cate_id(Short pro_cate_id) {
        this.pro_cate_id = pro_cate_id;
    }

    public String getPro_factory() {
        return pro_factory;
    }

    public void setPro_factory(String pro_factory) {
        this.pro_factory = pro_factory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id='" + pro_id + '\'' +
                ", pro_name='" + pro_name + '\'' +
                ", pro_price=" + pro_price +
                ", pro_image='" + pro_image + '\'' +
                ", pro_des='" + pro_des + '\'' +
                ", pro_stock=" + pro_stock +
                ", pro_date=" + pro_date +
                ", pro_cate_id=" + pro_cate_id +
                ", pro_factory='" + pro_factory + '\'' +
                '}';
    }
}
