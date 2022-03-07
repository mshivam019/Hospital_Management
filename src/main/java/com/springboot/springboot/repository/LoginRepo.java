package com.springboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springboot.entities.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login,Integer>{

	Login findByPassword(String password);

     Login findByUsername(String username);

}
