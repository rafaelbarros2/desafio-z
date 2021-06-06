package com.desafioz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioz.entities.Cars;


public interface CarsRepository extends JpaRepository<Cars, Long>{
	
}


