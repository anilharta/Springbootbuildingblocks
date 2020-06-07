package com.java.RestServices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.RestServices.Pojos.Users;
import com.java.RestServices.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<Users> getAllUsers() {
		return userRepository.findAll();

	}

	public Users createUser(Users user) {
		return userRepository.save(user);
	}

	public Optional<Users> getUserById(Long id) {
		Optional<Users> user = userRepository.findById(id);
		return user;
	}

	public Users updateUserById(Long id, Users user) {
		user.setId(id);
		return userRepository.save(user);
	}

	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	public Users findUserByUserName(String name) {
		return userRepository.findByUserName(name);
	}

}
