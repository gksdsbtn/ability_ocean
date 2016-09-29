package com.sindorim.abilityocean.dao;




import org.springframework.stereotype.Repository;

import com.sindorim.abilityocean.domain.User;

@Repository
public interface UserDao {
	
	void create(User user);

	User getUsers(User user);
	
}
