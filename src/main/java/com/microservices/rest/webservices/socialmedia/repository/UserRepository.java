package com.microservices.rest.webservices.socialmedia.repository;


import com.microservices.rest.webservices.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
