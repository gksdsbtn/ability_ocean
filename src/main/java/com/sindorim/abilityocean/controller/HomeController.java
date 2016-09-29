package com.sindorim.abilityocean.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="")
	String home(){
		
		logger.debug("Welcome to Home !! input login infomation");
		
		return "/web/home.jsp";
	}
	
	@RequestMapping(value="/handle")
	String handle(){
		logger.debug("아무것도 하지 않는다.");
		return "/web/handle.jsp";
	}
	
	@RequestMapping(value="/admin")
	String admin(){
		logger.debug("handle 타고 온 admin page");
		return "/web/admin.jsp";
	}
	
	@RequestMapping(value="/basic")
	String basic(){
		logger.debug("handle 타고 온 admin page");
		return "/web/basic.jsp";
	}
	
}
