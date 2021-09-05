package com.example.CursoprojetoSpring.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.CursoprojetoSpring.entities.User;
import com.example.CursoprojetoSpring.services.UserServices;



@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserServices services;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){

		List<User> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = services.findById(id);
		return  ResponseEntity.ok().body(obj);
	}
	
	@PostMapping //INSERIR
	public ResponseEntity<User> insert( @RequestBody  User obj){ //INSERIR USUARIO
		obj=services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return  ResponseEntity.created(uri).body(obj);
		 
	} 
	
	@DeleteMapping(value = "/{id}") //DELETAR USUARIO
	public ResponseEntity<Void> delete( @PathVariable Long id){
       services.delete(id);
       return ResponseEntity.noContent().build();	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = services.Update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
 