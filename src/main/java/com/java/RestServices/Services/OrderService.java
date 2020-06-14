package com.java.RestServices.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.RestServices.Pojos.Orders;
import com.java.RestServices.Repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Orders getUserIdAndOrderById (Long id, Long orderid) {
		return null;
		
	}

}
