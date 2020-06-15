package com.java.RestServices.Controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.java.RestServices.Exception.UserNotFoundException;
import com.java.RestServices.Pojos.Users;
import com.java.RestServices.Services.UserService;

@RestController
@Validated
@RequestMapping(value = "/hateoas/users")
public class UserHateoasController {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	public EntityModel<Users> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<Users> userOptional = userService.getUserById(id);
			Users user = userOptional.get();
			Long userId = user.getUserid();
			Link link = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
			EntityModel<Users> finalEm = EntityModel.of(user);
			finalEm.add(link);
			return finalEm;
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
//
//	@GetMapping()
//	public List<Users> getAllUsers() throws UserNotFoundException {
//		List<Users> usersList = new ArrayList<Users>();
//		for (Users user : userService.getAllUsers()) {
//			//Self Link
//			Link link = WebMvcLinkBuilder.linkTo(this.getClass()).slash(user.getUserid()).withSelfRel();
//			user.add(link);
//			usersList.add(user);
//			
////			//OrderLink
////			List<Orders> order = WebMvcLinkBuilder.methodOn(OrderController.class).getAllOrders(user.getUserid());
////			Link orderLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(order).withRel("user-order");
////			user.add(orderLink);
//			
//		}
//		return usersList;
	/*
	 * // }
	 * 
	 * //
	 * *****************************************************************************
	 * ***********************************************
	 * 
	 * @GetMapping() public List<Users> getAllUsers() throws UserNotFoundException {
	 * List<Users> usersList = new ArrayList<Users>();
	 * 
	 * for (Users user : userService.getAllUsers()) { //Adding self link user
	 * 'singular' resource Link link = WebMvcLinkBuilder
	 * .linkTo(UserController.class) .slash(user.getUserid()) .withSelfRel();
	 * user.add(link);
	 * 
	 * ResponseEntity<Orders> methodLinkBuilder =
	 * WebMvcLinkBuilder.methodOn(OrderController.class).getAllOrders(user.getUserid
	 * ()); Link reportLink = WebMvcLinkBuilder .linkTo(methodLinkBuilder)
	 * .withRel("user-report"); usersList.add(user); }
	 * 
	 * //Adding self link user collection resource Link selfLink =
	 * WebMvcLinkBuilder.linkTo(UserController.methodOn(UserController.class).
	 * getAllusers()).withSelfRel(); userList.add(selfLink);
	 * 
	 * //
	 * *****************************************************************************
	 * *********************************************** } return userList;
	 */
}