package com.java.vehi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.vehi.model.User;
import com.java.vehi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/Vehicle")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/create/data")
    public String postMethodName(@RequestBody User user) {
       String d=userService.getuserName(user);
       return d;
    }
    
    @GetMapping("/Gatdata")
    public List<User> getMethodName(){
        List<User> li=userService.getUserData();
        return li;
    }
    
    @PutMapping("/user/{userId}")
    public ResponseEntity<User> putMethodName(@PathVariable("userId") int id, @RequestBody User employee) {
        if(userService.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}
