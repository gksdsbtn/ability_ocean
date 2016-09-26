package com.sindorim.abilityocean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.sindorim.abilityocean.service.SampleIService;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	//private SampleIService sampleService;
	
	@RequestMapping(value = "/list")
	public String list(){
		
		System.out.println("TaeWoong List ");
		
		return "/web/woong/list.web";
	}

}
