package com.sindorim.abilityocean.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sindorim.abilityocean.domain.Board;

@Repository
public interface WoongDao {
	
	List<Board> list();

}
