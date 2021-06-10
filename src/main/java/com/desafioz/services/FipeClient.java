package com.desafioz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioz.entities.CarroFipe;
import com.desafioz.entities.RetornoFipe;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/carros", name = "fipeClient")
public interface FipeClient {
	
	@GetMapping("/marcas")
	List<RetornoFipe> getMarcas();
	
	@GetMapping("/marcas/{marca}/modelos/{modelo}")
	CarroFipe getModelosByMarca(@PathVariable("marca") int marca, 
			@PathVariable("modelo") String modelo);
	
	@GetMapping("/marcas/{marca}/modelos/{modelo}/anos/{ano}")
	CarroFipe getValor(@PathVariable("marca") int marca, 
			            @PathVariable("modelo") int modelo, 
			            @PathVariable("ano") String ano);
}
