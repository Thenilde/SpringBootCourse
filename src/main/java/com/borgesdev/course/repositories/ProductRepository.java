package com.borgesdev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borgesdev.course.entities.Product;

public interface  ProductRepository extends JpaRepository<Product, Long>{

}
