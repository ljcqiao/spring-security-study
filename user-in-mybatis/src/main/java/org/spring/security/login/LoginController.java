package org.spring.security.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "LOGIN SUCCESS!";
	}
	
	@RequestMapping("/myLogin")
	public String logFailure() {
		return "myLogin";
	}
}
