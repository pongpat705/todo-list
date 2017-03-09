package com.pongpat.assignment.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/api")
public class ApiController {

	@RequestMapping(value="/task/{id}")
	public void setStatusTask(){
		
	}
}
