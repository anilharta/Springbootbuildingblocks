package com.java.RestServices.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.RestServices.Pojos.Users;
import com.java.RestServices.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/newuser")
	public Users CreateNewUser(@RequestBody Users user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public Optional<Users> getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);		
	}
	
	@PutMapping("updateusersbyid/{id}")
	public Users updateUserById(@PathVariable("id") Long id, @RequestBody Users user) {
		return userService.updateUserById(id, user);
	}
	
	@DeleteMapping("/deleteuserbyid/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	@GetMapping("users/findusersbyname/{lastName}")
	public Users findUserByUserName(@PathVariable("lastName") String name) {
		return userService.findUserByUserName(name);		
	}

}
