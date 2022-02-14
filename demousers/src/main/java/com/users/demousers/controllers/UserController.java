package com.users.demousers.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.demousers.models.UserModel;
import com.users.demousers.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping()
	public ArrayList<UserModel> showUsers(){
		return userService.showUsers();
	}
	
	@PostMapping()
	public UserModel saveUser(@RequestBody UserModel user) {
		return this.userService.saveUser(user);
	}
	
	@GetMapping( path = "/{id}")
	public Optional<UserModel> showUserById(@PathVariable("id") Long id){
		return this.userService.showById(id);
	}
	
	@GetMapping("/query")
	public ArrayList<UserModel> showUserByPriority(@RequestParam("priority") Integer priority){
		return this.userService.showByPriority(priority);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok = this.userService.deleteUser(id);
		if(ok) {
			return "Deleted user with id: " + id;
		}else {
			return "Can't delete user with id: " + id;
		}
	}

}
