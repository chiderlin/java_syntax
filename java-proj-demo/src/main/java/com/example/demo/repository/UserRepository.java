// interface area

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  // import要用的裝飾器@Repository


// 原本JpaRepository就有一些預設的query功能 => findById(), findAll() ...
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  // define custom query methods. 
  User findByEmail(String email);

  User findByName(String name);
}
