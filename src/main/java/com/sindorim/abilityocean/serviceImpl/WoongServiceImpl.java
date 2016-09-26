package com.sindorim.abilityocean.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindorim.abilityocean.dao.WoongDao;
import com.sindorim.abilityocean.domain.Board;
import com.sindorim.abilityocean.service.WoongService;

@Service
public class WoongServiceImpl implements WoongService{

	private static final Logger logger = LoggerFactory.getLogger(WoongServiceImpl.class);
	
	@Autowired WoongDao woongDao;
	
	@Override
	public List<Board> list() {
		logger.debug("게시판 목록 가져오기 list()!!");
		return woongDao.list();
	}
	
}
