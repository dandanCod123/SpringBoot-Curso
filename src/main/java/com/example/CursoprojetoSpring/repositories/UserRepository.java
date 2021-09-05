package com.example.CursoprojetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CursoprojetoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
