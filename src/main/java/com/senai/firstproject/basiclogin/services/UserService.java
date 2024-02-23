package com.senai.firstproject.basiclogin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.firstproject.basiclogin.entities.User;
import com.senai.firstproject.basiclogin.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userrepository;
	
	public List<User>listuser(){
		return userrepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return userrepository.findById(id);
	}
	public User insert(User user) {
		return userrepository.save(user);
	}
	public void delete(Long id) {
		try {
			userrepository.deleteById(id);
		}catch (Exception e) {
			System.out.println("Algo deu errado ao excluir o usuario" +id);
		}
	}
	private void updateInfo(User user, User obj) {
		user.setFirstname(obj.getFirstname());
		user.setLastname(obj.getLastname());
		user.setPassword(obj.getPassword());
		user.setAgreedToTerms(obj.isAgreedToTerms());
		user.setNumberphone(obj.getNumberphone());
		userrepository.save(user);
	}
	public User update (Long id, User objuser) {
		try {
			User user = userrepository.getById(id);
			updateInfo(user, objuser);
			return userrepository.save(user);
		} catch (Exception e) {
			 e.printStackTrace();
			return null;
		}
	}
	
	public List<User> searchByName(String name) {
	    return userrepository.findByFirstnameContaining(name);
	}

}
