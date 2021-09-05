package com.example.CursoprojetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CursoprojetoSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
}
