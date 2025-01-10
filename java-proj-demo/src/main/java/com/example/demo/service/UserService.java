// business area
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  
  @Antowired
  private UserRepository userRepository;

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public User getUserById(Long id){
    return userRepository.findById(id).orElse(null);
  }
  // TODO: finish business logic
  // public
}
