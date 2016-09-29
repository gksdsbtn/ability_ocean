package com.sindorim.abilityocean.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sindorim.abilityocean.domain.User;
import com.sindorim.abilityocean.result.JsonResult;
import com.sindorim.abilityocean.service.UserService;
import com.sindorim.abilityocean.util.SessionUtil;

@Controller
@RequestMapping(value="/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserService userService;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	String signup(){
		
		logger.debug("user signup RequestMethod GET : page move");
		
		return "/web/user/signup.jsp";
	}
	
	
	@RequestMapping(value="/create")
	@ResponseBody
	JsonResult create(User user){
		JsonResult jsonResult = new JsonResult();
		
		try {
			userService.create(user);
			jsonResult.getHeader().setStatus("0000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	@RequestMapping(value="/login")
	@ResponseBody
	JsonResult login(User user, HttpServletRequest request){
		
		JsonResult jsonResult = new JsonResult();
		try {
			user = userService.getUsers(user);
			if(user == null){
				jsonResult.getHeader().setStatus("9999");
				return jsonResult;
			}
			
			SessionUtil.createUserSession(request, user);
			
			logger.debug("--------------------------------------------------------------");
			logger.debug("User Info [{}][{}]", user.getTwUserId(), user.getTwUserName());
			logger.debug("--------------------------------------------------------------");
			jsonResult.getHeader().setStatus("0000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
}
