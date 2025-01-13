package com.example.demo.model;

import org.springframework.stereotype.Indexed;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // annotation maps the class to a database table -> find User table
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  // Getter and Setter
  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getEmail(){
    // java可以直接使用email去抓取到變數，即便是在不同func
    // return email; 
    return this.email; // js 就一定要this，已習慣
  }

  public void setEmail(String email){
    this.email = email;
  }

}
