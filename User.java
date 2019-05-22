package com.neuedu.pojo;

public class User {


    public User()
    {

    }



    public User(Integer id, String username, String pasd) {
        this.id = id;
        this.username = username;
        this.pasd = pasd;
    }


    private  Integer id;

    private String username;

    private  String pasd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasd() {
        return pasd;
    }

    public void setPasd(String pasd) {
        this.pasd = pasd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pasd='" + pasd + '\'' +
                '}';
    }
}
