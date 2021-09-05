package com.example.CursoprojetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CursoprojetoSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
}
