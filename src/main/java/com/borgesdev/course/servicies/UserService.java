package com.borgesdev.course.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.borgesdev.course.entities.User;
import com.borgesdev.course.repositories.UserRepository;
import com.borgesdev.course.servicies.exceptions.DatabaseException;
import com.borgesdev.course.servicies.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	// implemente de 2 operacoes basicas :1 pra buscar todos os users and a
	// 2 outra pra buscar um user por id.

	@Autowired // dependecy
	private UserRepository repository;

	public List<User> findAll() {// metodo para retornar todos os users do banco de dado.
		return repository.findAll();

	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {

			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj){
		
		try {
		User entity =repository.getReferenceById(id);
		updateData(entity ,obj);
		return repository.save(entity);
		
		}catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
			
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
