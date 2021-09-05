package com.example.CursoprojetoSpring.services; //  CAMADA DE SERVICO PRATICAMENTE ELA INDICA AS REGRAS DO NEGOCIO, OU SEJA REGRAS A SEREM SEGUIDA

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CursoprojetoSpring.entities.Order;
import com.example.CursoprojetoSpring.repositories.OrderRepository;

@Service 
public class OrderServices {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
