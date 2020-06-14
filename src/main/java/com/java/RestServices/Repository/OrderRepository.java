package com.java.RestServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.RestServices.Pojos.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
	

}
