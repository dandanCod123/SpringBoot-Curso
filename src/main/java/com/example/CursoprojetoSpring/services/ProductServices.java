package com.example.CursoprojetoSpring.services; //  CAMADA DE SERVICO PRATICAMENTE ELA INDICA AS REGRAS DO NEGOCIO, OU SEJA REGRAS A SEREM SEGUIDA

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CursoprojetoSpring.entities.Product;
import com.example.CursoprojetoSpring.repositories.ProductRepository;

@Service 
public class ProductServices {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
