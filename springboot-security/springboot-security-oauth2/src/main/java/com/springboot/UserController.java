package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public List listUser(){
    return userService.findAll();
  }

  @PostMapping("/user")
  public User create(@RequestBody User user){
    return userService.save(user);
  }

  @DeleteMapping(value = "/user/{id}")
  public String delete(@PathVariable(value = "id") Long id){
    userService.delete(id);
    return "success";
  }
}
