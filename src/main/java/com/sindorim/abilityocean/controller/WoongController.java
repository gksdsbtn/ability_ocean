package com.sindorim.abilityocean.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sindorim.abilityocean.domain.Board;
import com.sindorim.abilityocean.result.JsonResult;
import com.sindorim.abilityocean.service.WoongService;

@Controller
@RequestMapping(value = "/woong")
public class WoongController {

	private static final Logger logger = LoggerFactory.getLogger(WoongController.class);
	
	@Autowired WoongService woongService;
	
	
	@RequestMapping(value="/list"  ,method=RequestMethod.GET )
	String list(Model model){
		List<Board> boardList = new ArrayList<Board>();
		boardList = woongService.list();
		
		model.addAttribute("boardList", boardList);
		
		return "/web/board/list.jsp";
	}
	
	/*@RequestMapping(value="/list"  ,method=RequestMethod.POST )
	JsonResult getList(){
		JsonResult jsonResult = new JsonResult();
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}*/
	
	
	
}
