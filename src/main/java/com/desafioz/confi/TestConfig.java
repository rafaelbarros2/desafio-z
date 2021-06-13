package com.desafioz.confi;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafioz.entities.Cars;
import com.desafioz.entities.User;
import com.desafioz.repositories.CarsRepository;
import com.desafioz.repositories.UserRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CarsRepository carsRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "01251408897", "10/03/1994");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "01251408899", "20/03/1994");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
//		carsRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}