package com.desafioz.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioz.entities.Cars;
import com.desafioz.repositories.CarsRepository;
import com.desafioz.services.exceptions.ArgumentoInvalidoExcepetion;
import com.desafioz.services.exceptions.ErroInternoExcepetion;
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
		verificarModelo(car.getModeloVeiculo());
		validarAno(car.getAnoVeiculo());
		
		String valorFipe = fipeClient.getValor(car.getCodigoMarca(), car.getCodigoModelo(), car.getAnoVeiculo()).getValor();
		car.setMoment(Instant.now());
		car.setValor(valorFipe);
		return repository.save(car);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void verificarMarca(int getCodigoMarca) {
		//TODO
		
		 if("".equals(getCodigoMarca) || getCodigoMarca == 0) {
			 throw new ArgumentoInvalidoExcepetion("Marca Invalida");
		 }
	}
	
	public void verificarModelo(String getModelo) {
		 if("".equals(getModelo) || getModelo == null) {
			 throw new ArgumentoInvalidoExcepetion("Ano inválido ");
		 }
	}
	
	public void validarAno(String getAnoVeiculo) {
		 if("".equals(getAnoVeiculo) || getAnoVeiculo == null) {
			 throw new ArgumentoInvalidoExcepetion("Ano inválido ");
		 }
	}

	public Cars updateCar(Long id, Cars car) {
		if (!repository.existsById(id))
			throw new ResourceNotFoundExceptions("Carro não encontrado: ", id);
		
		try {
			car.setId(id);
			return repository.saveAndFlush(car);
		} catch (ErroInternoExcepetion e) {
			throw new ErroInternoExcepetion("Deu ruim!");
		}

	}

	public void delete(Long id) {
		if (!repository.existsById(id))
			throw new ResourceNotFoundExceptions("Carro não encontrado: ", id);
		
		try {
			repository.deleteById(id);
		} catch (ArgumentoInvalidoExcepetion e) {
			throw new ArgumentoInvalidoExcepetion("Deu ruim!", e.getCause());
		}
	}

}
