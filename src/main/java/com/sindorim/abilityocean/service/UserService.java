package com.sindorim.abilityocean.service;


import org.springframework.transaction.annotation.Transactional;

import com.sindorim.abilityocean.domain.User;

@Transactional
public interface UserService {
	
	void create(User user);
	
	User getUsers(User user);

}
