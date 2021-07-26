package org.spring.security.user;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/getUser")
	@ResponseBody
	public String getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails)principal;
		String username = user.getUsername();
		return username;
	}
	
	@GetMapping("/getAuthentication")
	public void getAuthentication(Authentication auth,HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		Map<String,String> result  = new HashMap<String,String>();
		result.put("status", "0");
		result.put("msg", "获取用户信息成功");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(auth);
		response.getWriter().write(s);
	}
	
	@GetMapping("/getPricipal")
	public void getPricipal(Principal pricical,HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		Map<String,String> result  = new HashMap<String,String>();
		result.put("status", "0");
		result.put("msg", "获取用户信息成功");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(pricical);
		response.getWriter().write(s);
	}

}
