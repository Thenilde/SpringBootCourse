package com.borgesdev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borgesdev.course.entities.User;

public interface  UserRepository extends JpaRepository<User, Long>{

}
