package com.sindorim.abilityocean.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindorim.abilityocean.domain.Board;

@Transactional
public interface WoongService {

	List<Board> list();
	
}
