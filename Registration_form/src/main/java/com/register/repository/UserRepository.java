package com.register.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);

	

}
