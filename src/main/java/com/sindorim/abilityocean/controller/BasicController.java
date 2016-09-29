package com.sindorim.abilityocean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/basic")
public class BasicController {

	
	@RequestMapping(value="/home")
	String home(){
		return "/web/basic/home.jsp";
	}
	
}
