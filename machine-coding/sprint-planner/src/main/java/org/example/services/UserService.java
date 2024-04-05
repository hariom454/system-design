package org.example.services;

import java.util.HashMap;
import org.example.dtos.User;

public class UserService {
  HashMap<String, User> users = new HashMap<>();
  public User getUser(String id){
    //
    if(users.containsKey(id))
    {
      return users.get(id);
    }
    throw new RuntimeException("user not found!");
  }

}
