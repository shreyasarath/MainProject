package com.verizon.tsp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tsp.dao.UserDao;
import com.verizon.tsp.models.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;
	
	@Override
	public User findByUserId(long userId) {
		User user = null;
		
		Optional<User> optUser = userdao.findById(userId);
		
		if( optUser.isPresent()) {
			user = optUser.get();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userdao.findAll();
	}

	@Override
	public User createUser(User user) {
		return userdao.save(user);
		
	}

	@Override
	public boolean deleteUser(long userId) {
		
		boolean isDeleted=false;
		if(userdao.existsById(userId)) {
			userdao.deleteById(userId);
			isDeleted=true;
		}
		
		return isDeleted;

	}

}
