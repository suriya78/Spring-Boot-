package com.java.vehi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.vehi.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
