package com.example.CursoprojetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CursoprojetoSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
