package com.verizon.tsp.services;

import java.util.List;

import com.verizon.tsp.models.User;

public interface UserService {

	public List<User> getAllUsers();
	public User findByUserId(long userId); //getbyid
	public User createUser(User user);
	public boolean deleteUser(long userId);
}
