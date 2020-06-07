package com.java.RestServices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.RestServices.Exception.UserNameNotFoundException;
import com.java.RestServices.Exception.UserNotFoundException;
import com.java.RestServices.Pojos.Users;
import com.java.RestServices.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<Users> getAllUsers() throws UserNotFoundException {
		List<Users> user = userRepository.findAll();
		for (Users u : user) {
			if (u == null) {
				throw new UserNotFoundException("No User Found");
			}
		}
		return userRepository.findAll();
	}

	public Users createUser(Users user) throws UserNotFoundException {
		Users isExistingUser = userRepository.findByUserName(user.getUserName());
		if (isExistingUser != null) {
			throw new UserNotFoundException("User " + user.getUserName() + " is alrady availabe");
		}
		return userRepository.save(user);
	}

	public Optional<Users> getUserById(Long id) throws UserNotFoundException {

		Optional<Users> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User with id " + id + " is not availabe");
		}
		return user;
	}

	public Users updateUserById(Long id, Users user) throws UserNotFoundException {
		Optional<Users> optionaluser = userRepository.findById(id);
		if (!optionaluser.isPresent()) {
			throw new UserNotFoundException("User with id " + id + " is not availabe");
		}
		user.setId(id);
		return userRepository.save(user);
	}

	public void deleteUserById(Long id) throws UserNotFoundException {
		boolean isUserPreset = userRepository.findById(id).isPresent();
		if (!isUserPreset) {
			throw new UserNotFoundException("User with id " + id + " is not availabe, so Nothing to delete");
		} else {
			userRepository.deleteById(id);
		}
	}

	public Users findUserByUserName(String name) throws UserNameNotFoundException {
//		Users isUserAvailable = userRepository.findByUserName(name);
//		if (isUserAvailable == null) {
//			throw new UserNameNotFoundException("User " + name + " is not availabe!!!!");
//		} 
		  return userRepository.findByUserName(name);
	}
}
