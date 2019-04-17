package com.jerry.myservlet.domain;

public class User {
    @Override
    public String toString() {
        return super.toString();
    }
    
    private Integer _id;
    private String username;
    private String userpwd;

    public User(){}
    public User(String username,String userpwd){
        this.username = username;
        this.setUserpwd(userpwd);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    public Integer get_id() {
        return _id;
    }
    public void set_id(Integer _id) {
        this._id = _id;
    }
}