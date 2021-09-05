package com.example.CursoprojetoSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CursoprojetoSpring.entities.Category;
import com.example.CursoprojetoSpring.services.CategoryServices;



@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryServices services;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){

		List<Category> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = services.findById(id);
		return  ResponseEntity.ok().body(obj);
	}
}
 