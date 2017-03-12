package com.pongpat.assignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		String address = request.getRemoteAddr();
		return "Hello "+address+" this is todo API";
	}
}
