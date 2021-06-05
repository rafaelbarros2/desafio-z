package com.desafioz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioz.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}


