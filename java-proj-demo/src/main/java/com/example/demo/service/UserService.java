// business area
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  
  private final UserRepository userRepository;
  
  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public User getUserById(Long id){
    return userRepository.findById(id).orElse(null);
  }

  public User createUser(User user){
    return userRepository.save(user);
  }

  public User updateUser(Long id, User userDetails){
    User user = userRepository.findById(id).orElse(null);
    if(user != null){
      user.setName(userDetails.getName());
      user.setEmail(userDetails.getEmail());
      return userRepository.save(user);
    }
    return null;
  }

  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }

}
