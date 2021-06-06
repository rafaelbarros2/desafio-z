package com.desafioz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioz.entities.Cars;
import com.desafioz.repositories.CarsRepository;




@Service
public class CarsService {

	@Autowired
	private CarsRepository repository;
	
	public List<Cars> findAll(){
		
		return repository.findAll();
	}
	
	public Cars findByid(Long id) {
		Optional<Cars> obj = repository.findById(id);
		return obj.get();
	}
	
}

