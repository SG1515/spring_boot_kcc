//package com.kcc.restfulservice.controller;
//
//import com.kcc.restfulservice.UserDaoService;
//import com.kcc.restfulservice.bean.Post;
//import com.kcc.restfulservice.bean.User;
//import com.kcc.restfulservice.exception.UserNotFoundException;
//import com.kcc.restfulservice.repository.PostRepository;
//import com.kcc.restfulservice.repository.UserRepository;
//import jakarta.validation.Valid;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//@RestController
//@RequestMapping("/jpa")
//public class UserJpaController {
//
//    private UserRepository userRepository;
//    private PostRepository postRepository;
//
//    public UserJpaController(UserRepository userRepository, PostRepository postRepository) {
//        this.userRepository = userRepository;
//        this.postRepository = postRepository;
//    }
//
//
//    @GetMapping("/users")
//    public List<User> retrieveAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public EntityModel retrieveUser(@PathVariable int id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        EntityModel entityModel = EntityModel.of(user);
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        entityModel.add(linkTo.withRel("all-users"));
//        return entityModel;
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
//        User savedUser = userRepository.save(user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id) {
//        int tmpIdNumber = id;
//        userRepository.deleteById(id);
//
//        if(tmpIdNumber == 0) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//    }
//
//    @GetMapping("/users/{id}/posts")
//    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if(!user.isPresent()){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        return user.get().getPosts();
//    }
//
//    @PostMapping("/users/{id}/posts")
//    public ResponseEntity<Post> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
//
//        Optional<User> user = userRepository.findById(id);
//        post.setUser_id(user.get().getId());
//        Post savedPost = postRepository.save(post);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedPost.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @GetMapping("/users/{id}/posts/{postNumber}")
//    public Post searchPost(@PathVariable int id, @PathVariable int postNumber) {
//        Optional<User> userOptional = userRepository.findById(id);
//
//        if(!userOptional.isPresent()){
//            throw new UserNotFoundException(String.format("ID[%s] not found or Post[%s] not found", id, postNumber));
//
//        }
//        User user = userOptional.get();
//        List<Post> posts = user.getPosts();
//        Post post = null;
//
//        for(int i=0; i<posts.size(); i++){
//            post = posts.get(i);
//            if(post.getId() == postNumber){
//                return post;
//            }
//        }
//
//        return null;
//    }
//
//
//}
