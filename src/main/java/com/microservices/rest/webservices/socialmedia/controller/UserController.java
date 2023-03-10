package com.microservices.rest.webservices.socialmedia.controller;

import com.microservices.rest.webservices.socialmedia.repository.PostRepository;
import com.microservices.rest.webservices.socialmedia.repository.UserRepository;
import com.microservices.rest.webservices.socialmedia.model.Post;
import com.microservices.rest.webservices.socialmedia.model.User;
import com.microservices.rest.webservices.socialmedia.exception.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserController(UserRepository userRepository, PostRepository postRepository) {

        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // http://localhost:8080/users
    //Entity Model
    //WebMvcLinkBuilder

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id) {

        Optional<User> user = userRepository.findById(id); // convert to predicate
        if (user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {

        userRepository.deleteById(id); // convert to predicate
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id); // convert to predicate
        if (user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        return user.get().getPosts(); // convert to predicate
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<User> createPostForUser(@PathVariable int id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id); // convert to predicate
        if (user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
