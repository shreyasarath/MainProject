package com.verizon.tsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tsp.models.User;
import com.verizon.tsp.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
//@CrossOrigin

public class UserController {

	@Autowired
	UserServiceImpl userservice;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(userservice.getAllUsers(),HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> findByUserId(@PathVariable("id") long userId) {
		
		ResponseEntity<User> resp;
		
		User user = userservice.findByUserId(userId);
		
		if (user == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(user, HttpStatus.OK);
		
		return resp;
	}
	
	@PostMapping	
	public ResponseEntity<User> createUser(@RequestBody User user) {
		ResponseEntity<User> resp = null;
		
		User user_return = userservice.createUser(user);
		
		if(user_return != null) {
			resp = new ResponseEntity<>(user_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}


	@DeleteMapping("{userId}")	
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) {
		ResponseEntity<Void> resp = null;

		if (userservice.deleteUser(userId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}


}
