package com.pongpat.assignment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pongpat.assignment.constant.TaskStatus;

@RestController
@RequestMapping(value="/api")
public class ApiController {

	@RequestMapping(value="/status", method = RequestMethod.GET)
	public Map<TaskStatus, String> getTaskStatus(HttpServletRequest request){
		
		Map<TaskStatus, String> map = new HashMap<TaskStatus, String>();
		
		for (TaskStatus ts : TaskStatus.values()) {
			map.put(ts, ts.getStatus());
		}
		
		return map;
	}
}
