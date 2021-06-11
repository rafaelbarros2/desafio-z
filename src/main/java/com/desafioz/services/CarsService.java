package com.desafioz.services;

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
		try {
			
			verificarMarca(car.getCodigoMarca());
			verificarModelo();
			validarAno(car.getAnoVeiculo());
			
			String valorFipe = fipeClient.getValor(car.getCodigoMarca(), car.getCodigoModelo(), car.getAnoVeiculo()).getValor();
			
			car.setValor(valorFipe);
			return repository.save(car);
		} catch (Exception e) {
			throw new GeneralExcpetion("Deu ruim!");
		}
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
		Cars car = new Cars();
		 if("".equals(car.getAnoVeiculo()) && car.getAnoVeiculo() == null){
			 throw new ResourceNotFoundExceptions("Carro não encontrado: ", null);
		        
		 }else{
		        	throw new ResourceNotFoundExceptions("Carro encontrado: ", null);
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
