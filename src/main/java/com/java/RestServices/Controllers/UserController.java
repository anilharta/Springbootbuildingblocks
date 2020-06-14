package com.java.RestServices.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.java.RestServices.Exception.UserNameNotFoundException;
import com.java.RestServices.Exception.UserNotFoundException;
import com.java.RestServices.Pojos.Users;
import com.java.RestServices.Services.UserService;

@RestController
@Validated
@RequestMapping(value = "/AppUsers")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/allUsers")
	public List<Users> getAllUsers() {
		try {
			return userService.getAllUsers();
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@PostMapping("/CreateUser")
	public ResponseEntity<Void> CreateNewUser(@Valid @RequestBody Users user, UriComponentsBuilder builder) {
		try {
			userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/newuser").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.FOUND, ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public Optional<Users> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@PutMapping("updateusersbyid/{id}")
	public Users updateUserById(@PathVariable("id") Long id, @RequestBody Users user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@DeleteMapping("/deleteuserbyid/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		try {
			userService.deleteUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@GetMapping("findusersbyname/{username}")
	public Users findUserByUserName(@PathVariable("username") String name) throws UserNameNotFoundException{
		Users users = userService.findUserByUserName(name);
		if(users == null)
			throw new UserNameNotFoundException("User Name "+name+" not found");
		return userService.findUserByUserName(name);
		}
	
}
