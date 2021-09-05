package com.example.CursoprojetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CursoprojetoSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
