package com.java.vehi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.vehi.model.User;
import com.java.vehi.repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public String getuserName(User user) {
        userRepo.save(user);
        return user.getUser_name();
    }

    public List<User> getUserData() {
       List<User> li=new ArrayList<>(userRepo.findAll());
       return li;
    }
   
    public boolean updateDetails(int id, User u)
    {
        if (!userRepo.existsById(id)) {
            return false; 
        }
        try {
            u.setUser_id(id); 
            userRepo.save(u);
        } catch (Exception e) {
            return false; 
        }
        return true; 
    }
    
}
