package com.java.vehi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.vehi.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer>{
}
