package com.borgesdev.course.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borgesdev.course.entities.User;
import com.borgesdev.course.repositories.UserRepository;

@Service
public class UserService {
	//implemente de 2 operacoes basicas :1 pra buscar todos os users and a
	// 2 outra pra buscar um user por id.  
	
	@Autowired //dependecy
	private UserRepository repository;
	
	public List<User>findAll(){//metodo para retornar todos os users do banco de dado.
		return repository.findAll();
	
}
	public User findById(Long id) {
		Optional<User>obj=repository.findById(id);
		return obj.get();
	}
}
