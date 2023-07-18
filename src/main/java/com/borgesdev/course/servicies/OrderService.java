package com.borgesdev.course.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borgesdev.course.entities.Order;
import com.borgesdev.course.repositories.OrderRepository;

@Service
public class OrderService {
	//implemente de 2 operacoes basicas :1 pra buscar todos os users and a
	// 2 outra pra buscar um user por id.  
	
	@Autowired //dependecy
	private OrderRepository repository;
	
	public List<Order>findAll(){//metodo para retornar todos os users do banco de dado.
		return repository.findAll();
	
}
	public Order findById(Long id) {
		Optional<Order>obj=repository.findById(id);
		return obj.get();
	}
}
