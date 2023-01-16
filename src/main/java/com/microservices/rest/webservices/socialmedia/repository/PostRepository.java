package com.microservices.rest.webservices.socialmedia.repository;

import com.microservices.rest.webservices.socialmedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
