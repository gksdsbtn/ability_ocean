package com.sindorim.abilityocean.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindorim.abilityocean.dao.UserDao;
import com.sindorim.abilityocean.domain.User;
import com.sindorim.abilityocean.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserDao userDao;
	
	
	@Override
	public void create(User user) {
		userDao.create(user);
	}
	
	@Override
	public User getUsers(User user) {
		return userDao.getUsers(user);
	}
	
}
