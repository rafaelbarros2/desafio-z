package com.desafioz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioz.entities.CarroFipe;
import com.desafioz.entities.Marca;

@FeignClient(url = " https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos", name = "fipeClient")
public interface FipeClient {
	
	@GetMapping("/marcas")
	List<Marca> getMarcas();
	
	@GetMapping("marcas/{marca}/modelos/{modelo}/anos/{ano}")
	List<CarroFipe> getValor(@PathVariable("marca") int marca, 
			            @PathVariable("modelo") String modelo, 
			            @PathVariable("ano") String ano);
		
}
