package com.senai.firstproject.basiclogin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.firstproject.basiclogin.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByFirstnameContaining(String name);
 
}
