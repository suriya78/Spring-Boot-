package com.java.vehi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.vehi.model.User;
import com.java.vehi.model.Vehicle;
import com.java.vehi.repository.UserRepo;
import com.java.vehi.repository.VehicleRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    public List<User> getAllUsers(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return userRepo.findAll(pageable).getContent();
    }
    public User createUser(User user) {
        userRepo.save(user);
        return user;
    }

    public List<User> getAllUsers() {
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

    public boolean deleteExample(int id) {
        if (userRepo.existsById(id)) 
        {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Vehicle createUser(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public List<User> getAllUsers(Integer pageNo, Integer pageSize, String sortBy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    
    
}
