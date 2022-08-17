package com.first.springboot.restapi.helloworld;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @RequestMapping("/hello-world")
    public String HelloWorld(){

        return "Hello hhWorld";
    }

    @RequestMapping("/hello-world/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean ("Hola"+name);
    }
}
