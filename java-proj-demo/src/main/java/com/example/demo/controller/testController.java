package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

@RestController
public class testController {
  @GetMapping("/bad")
  public ResponseEntity<String> badPage(){
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_TYPE, "text/plain");

    return new ResponseEntity<String>("This Page Not Found", headers, 404);
  }
}
