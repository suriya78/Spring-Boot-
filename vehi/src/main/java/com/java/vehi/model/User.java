package com.java.vehi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private int user_id;
    private String user_name;
    private String Email;
    private String createPassword;
    private String re_Enter;
    
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Vehicle> vehicle;
    
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getCreatePassword() {
        return createPassword;
    }
    public void setCreatePassword(String createPassword) {
        this.createPassword = createPassword;
    }
    public String getRe_Enter() {
        return re_Enter;
    }
    public void setRe_Enter(String re_Enter) {
        this.re_Enter = re_Enter;
    }
   
}