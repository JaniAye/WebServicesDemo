package com.tryservices.rest.webservices.demos.user;


// import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.hateoas.CollectionModel;

//import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import static org.springframework.hateoas.*;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class userResourse {
    @Autowired
    private UserDAOService serviceserDAO;

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return serviceserDAO.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retriveSingleUser(@PathVariable int id){
        User one = serviceserDAO.findOne(id);
        if (one==null){
            throw new UserNotFoundException("id - "+id);
        }
        EntityModel<User> resource=new EntityModel<User>(one);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object>  createUser(@Validated @RequestBody User user){
        User saved = serviceserDAO.save(user);

        //return current uri
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();

       return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User one = serviceserDAO.DeleteById(id);
        if (one==null){
            throw new UserNotFoundException("id - "+id);
        }

    }


}
