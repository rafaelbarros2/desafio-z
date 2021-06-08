package com.desafioz.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioz.entities.CarroFipe;
import com.desafioz.entities.Marca;
import com.desafioz.services.FipeClient;

@RestController
@RequestMapping("/fipe")



public class FipeResource {
	
	private final FipeClient fipeClient;
	
	public FipeResource(FipeClient fipeClient) {
		this.fipeClient = fipeClient;
	}
	
	@GetMapping("/marcas")
	List<Marca> getMarcas() {
		return fipeClient.getMarcas();
	}
	
	@GetMapping("marcas/{marca}/modelos/{modelo}/anos/{ano}")
	List<CarroFipe> getValor(@PathVariable("marca") int marca, 
			            @PathVariable("modelo") String modelo, 
			            @PathVariable("ano") String ano) {
		
		return fipeClient.getValor(marca, modelo, ano);
	}
		
	
	
}