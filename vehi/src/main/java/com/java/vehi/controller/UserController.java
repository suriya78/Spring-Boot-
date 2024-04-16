package com.java.vehi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.vehi.model.User;
import com.java.vehi.model.Vehicle;
import com.java.vehi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/Vehicle")
public class UserController {
    
    @Autowired
    private UserService userService;


    @GetMapping("/Get")
    public ResponseEntity<List<User>> getAllUsers(Integer pageNo, Integer pageSize, String sortBy) {
        List<User> userList = userService.getAllUsers(pageNo, pageSize, sortBy);
        if (!userList.isEmpty()) {
            return ResponseEntity.ok().body(userList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/create/data")
    public ResponseEntity<User> createUser(@RequestBody User user) {
       User createdUser = userService.createUser(user);
       if (createdUser != null) {
           return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
       } else {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
    
    @GetMapping("/Getdata")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        if (!userList.isEmpty()) {
            return ResponseEntity.ok().body(userList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> putMethodName(@PathVariable("userId") int id, @RequestBody User employee) {
        if(userService.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExample(@PathVariable("id") int id)
    {
        boolean deleted =userService.deleteExample(id);
        if (deleted) 
            return ResponseEntity.ok().body("Deleted Sucessfully");
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/vehicle")
    public ResponseEntity<Vehicle> postMethodName(@RequestBody Vehicle vehicle) {
        Vehicle v=userService.createUser(vehicle);
        if(v==null)
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(v);
    }
    
}
