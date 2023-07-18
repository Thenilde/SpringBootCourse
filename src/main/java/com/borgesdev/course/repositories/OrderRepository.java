package com.borgesdev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borgesdev.course.entities.Order;

public interface  OrderRepository extends JpaRepository<Order, Long>{

}
