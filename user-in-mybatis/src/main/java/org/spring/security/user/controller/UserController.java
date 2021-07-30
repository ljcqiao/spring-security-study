package org.spring.security.user.controller;

import org.spring.security.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
@RequestMapping("/user")
public class UserController {

	@ResponseBody
	@RequestMapping("/getUser")
	public String getCurrentUser() throws JsonProcessingException  {
		User currentUser =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ObjectMapper om = new ObjectMapper();
		String st = om.writeValueAsString(currentUser);
		
		return st;
	}
	
}
