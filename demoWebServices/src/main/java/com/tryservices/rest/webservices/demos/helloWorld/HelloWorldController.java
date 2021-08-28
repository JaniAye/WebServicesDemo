package com.tryservices.rest.webservices.demos.helloWorld;

import org.springframework.web.bind.annotation.*;

//Handle Rest Requests
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
     public String helloWorld(){
         return "Hello World";
     }


    @GetMapping(path = "/helloBean/path/{name}")
    public HelloBean helloWorldBeanPath(@PathVariable String name){

//        %s replace by the name
        return new HelloBean(String.format("Hello World, %s",name));
    }
    //return bean
    @GetMapping(path = "/helloBean")
    public HelloBean helloWorldBean(){
        return new HelloBean("Hello World");
    }
}
