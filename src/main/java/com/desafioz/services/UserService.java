package com.desafioz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafioz.entities.Cars;
import com.desafioz.entities.User;
import com.desafioz.repositories.CarsRepository;
import com.desafioz.repositories.UserRepository;
import com.desafioz.services.exceptions.DatabaseException;
import com.desafioz.services.exceptions.ResourceNotFoundExceptions;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CarsRepository carRepository;
	
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findByid(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundExceptions("Usuário não foi encotnrado: ",id));
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
		
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExceptions("Usuário não foi encontrado: " ,id);
		}
		 catch(DataIntegrityViolationException e) {
			 throw new DatabaseException(e.getMessage());
		 }
		}
	

	@SuppressWarnings("deprecation")
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
	entity.setName(obj.getName());
	entity.setEmail(obj.getEmail());
	entity.setPhone(obj.getPhone());
	
		
	}

	public void adquirirCarro(Long userId, List<Cars> carsList) {
		//buscar o usuário
		User user = repository.getById(userId);
		//Se não trazer nenhum usuario, é porque não existe, logo mostre a mensagem de usuario não encontrado

		//buscar carro
		//
		//Se não trazer nenhum carro, é porque não existe, logo mostre a mensagem de usuario não encontrado
			
		for (Cars car : carsList) {
			Cars carro = carRepository.getById(car.getId());
			user.addCar(carro);
		}
		// Adicionar o carro dentro de usuário
		
		//persiste o usuário
		 repository.saveAndFlush(user);
		
	}
	
	}
	


