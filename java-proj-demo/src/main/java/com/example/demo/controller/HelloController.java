package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;



// @RestController: tells spring that this class contains methods to deal
// with HTTP requests.
@RestController
public class HelloController {

  
  @GetMapping("/hello")
  public Map<String, Object> sayHello(){

    Map<String, Object> res = new HashMap<>();
    res.put("status", "sucess");
    res.put("message","Hello, World!");
    return res;

    // return "Hello, World!";
    // there's many way to return JSON format 
    // return {"message": "Hello, World";}
  }
}


