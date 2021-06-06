package com.desafioz.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Cars> findeById(@PathVariable Long id){
		Cars obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
}
}