package com.sindorim.abilityocean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	
	@RequestMapping(value="/home")
	String home(){
		return "/web/admin/home.jsp";
	}
	
}