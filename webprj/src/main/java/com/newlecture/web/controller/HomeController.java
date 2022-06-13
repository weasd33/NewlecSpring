package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("root.index");
		mv.addObject("data", "Hello Spring MVC");
		//mv.setViewName("/WEB-INF/view/index.jsp");
		
		return mv;
	}
	*/
	
	@RequestMapping("index")
	public String index() {
		
		return "root.index";
	}
	
}
