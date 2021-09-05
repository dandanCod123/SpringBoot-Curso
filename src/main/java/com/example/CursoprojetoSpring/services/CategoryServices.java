package com.example.CursoprojetoSpring.services; //  CAMADA DE SERVICO PRATICAMENTE ELA INDICA AS REGRAS DO NEGOCIO, OU SEJA REGRAS A SEREM SEGUIDA

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CursoprojetoSpring.entities.Category;
import com.example.CursoprojetoSpring.repositories.CategoryRepository;

@Service 
public class CategoryServices {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
