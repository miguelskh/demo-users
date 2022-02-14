package com.users.demousers.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.demousers.models.UserModel;
import com.users.demousers.repositories.UserRepository;

@Service
public class UserService {
	
  @Autowired	
  UserRepository userRepository;
  
  public ArrayList<UserModel> showUsers(){
	  
	  return (ArrayList<UserModel>)userRepository.findAll();
  }
  
  
  public UserModel saveUser(UserModel user) {
	   
	  return userRepository.save(user);
	  
  }
  
  public Optional<UserModel> showById(Long id){
	  return userRepository.findById(id);
  }
  
  
  public ArrayList<UserModel> showByPriority(Integer priority){
	  return userRepository.findByPriority(priority);
  }
  
  public boolean deleteUser(Long id) {
	  
	  try {
		  userRepository.deleteById(id);
		  return true;
	  }catch(Exception err) {
		  return false;
	  }
	  
  }

}
