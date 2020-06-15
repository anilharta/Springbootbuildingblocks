package com.java.RestServices.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.RestServices.Exception.UserNotFoundException;
import com.java.RestServices.Pojos.Orders;
import com.java.RestServices.Pojos.Users;
import com.java.RestServices.Repository.OrderRepository;
import com.java.RestServices.Repository.UserRepository;

@RestController
@RequestMapping(value = "/hateoas")
public class OrdersHateoasController {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping(value = "/{userid}/orders")
	public List<Orders> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {

		Optional<Users> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		return userOptional.get().getOrders();
	}

}
