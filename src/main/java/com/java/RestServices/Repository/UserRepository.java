package com.java.RestServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.RestServices.Pojos.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUserName(String username);
}
