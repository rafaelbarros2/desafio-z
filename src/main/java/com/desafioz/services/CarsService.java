package com.desafioz.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioz.entities.Cars;
import com.desafioz.repositories.CarsRepository;
import com.desafioz.services.exceptions.GeneralExcpetion;
import com.desafioz.services.exceptions.ResourceNotFoundExceptions;

@Service
public class CarsService {

	@Autowired
	private CarsRepository repository;
	
	@Autowired
	private FipeClient fipeClient;

	public List<Cars> findAll() {

		return repository.findAll();
	}

	public Cars findByid(Long id) {
		Optional<Cars> obj = repository.findById(id);
		return obj.get();
	}

	public Cars insertCar(Cars car) {
		verificarMarca(car.getCodigoMarca());
		verificarModelo();
		validarAno(car.getAnoVeiculo());
		
		String valorFipe = fipeClient.getValor(car.getCodigoMarca(), car.getCodigoModelo(), car.getAnoVeiculo()).getValor();
		car.setMoment(Instant.now());
		car.setValor(valorFipe);
		return repository.save(car);
	}
	
	public void verificarMarca(int codigoMarca) {
		//TODO
		
		
			// TODO: handle exception
		
		// buscar marca na api da fipe
		
		
		// verificar se a marca existe na lista do retorno da fipe
		
		// se não exisitr lançar um erro
	}
	
	public void verificarModelo() {
		
	}
	
	public void validarAno(String getAnoVeiculo) {
		 if("".equals(getAnoVeiculo) || getAnoVeiculo == null) {
			 throw new ResourceNotFoundExceptions("Ano inválido: ", getAnoVeiculo);
		 }
	}

	public Cars updateCar(Long id, Cars car) {
		try {
			if (!repository.existsById(id))
				throw new ResourceNotFoundExceptions("Carro não encontrado: ", id);

			car.setId(id);
			return repository.saveAndFlush(car);
		} catch (Exception e) {
			throw new GeneralExcpetion("Deu ruim!");
		}

	}

	public void delete(Long id) {
		try {
			if (!repository.existsById(id))
				throw new ResourceNotFoundExceptions("Carro não encontrado: ", id);

			repository.deleteById(id);
		} catch (GeneralExcpetion e) {
			throw new GeneralExcpetion("Deu ruim!", e.getCause());
		}
	}

}
