package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController: tells spring that this class contains methods to deal
// with HTTP requests.
@RestController
@RequestMapping("/api/users") // 統一入口
public class UserController {
  
  // @Autowired: tells spring to set up when the application starts.
  @Autowired
  private UserService userService;


  // @GetMapping(PATH): Get method
  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id){
    return userService.getUserById(id);
  }

  // @PostMapping: Post method
  @PostMapping
  public User createUser(@RequestBody User user){
    return userService.createUser(user);
  }

  // @PutMapping: Put method
  @PutMapping("/{id}")
  public User upadteUser(@PathVariable Long id, @RequestBody User userDetails){
    return userService.updateUser(id, userDetails);
  }

  // @DeleteMapping: Delete method
  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
    return "User deleted with id: " + id;
  }
}
