package com.desafioz.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioz.entities.Cars;
import com.desafioz.services.CarsService;

@RestController
@RequestMapping(value = "/cars")
public class CarsResource {
	
	@Autowired
	private CarsService service;
	
	@GetMapping
	public ResponseEntity<List<Cars>> findAll(){
		List<Cars> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cars> findById(@PathVariable Long id){
		Cars obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
}
	
	@PostMapping
	public ResponseEntity<Void> insertCar(@RequestBody Cars obj) {
		service.insertCar(obj);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cars> updateCar(@PathVariable Long id, @RequestBody Cars obj) {		
		service.updateCar(id, obj);
		return ResponseEntity.status(201).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}