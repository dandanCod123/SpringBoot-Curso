package com.example.CursoprojetoSpring.services; //  CAMADA DE SERVICO PRATICAMENTE ELA INDICA AS REGRAS DO NEGOCIO, OU SEJA REGRAS A SEREM SEGUIDA

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.CursoprojetoSpring.entities.User;
import com.example.CursoprojetoSpring.repositories.UserRepository;
import com.example.CursoprojetoSpring.services.exceptions.DataBaseException;
import com.example.CursoprojetoSpring.services.exceptions.ResourceNotFoundException;

@Service 
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) { //OPERAÇÃO NO BAMCO DE DADOS PARA INSERIRI UM NOVO OBJETO DO TIPO USER	
			return repository.save(obj);
}
	
	public void delete(Long id) { //OPERAÇÃO PARA DELETAR UM USUARIO 
		try { 
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
		}
	}
	
	public User Update(Long id, User obj) { //ATUALIZAR USUARIO
		try {
		User entity = repository.getOne(id);
		updateData(entity ,obj);
	    return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) { //ATUALIZAR OS DADOS DO ENTITY COM BASE NO QUE RECEBEU NO OBJ
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
