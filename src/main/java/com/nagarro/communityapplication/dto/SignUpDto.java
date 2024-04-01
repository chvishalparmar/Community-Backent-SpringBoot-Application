package com.nagarro.communityapplication.dto;


public class SignUpDto {

    private String name;
    private String email;
    private String password;
    private int age;
    private String phonenumber;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonemumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
