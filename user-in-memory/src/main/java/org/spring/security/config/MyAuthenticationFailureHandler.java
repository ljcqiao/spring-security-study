package org.spring.security.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		response.setContentType("application/json;charset=utf-8");
		Map<String,String> result  = new HashMap<String,String>();
		result.put("status", "1");
		result.put("msg", "登录失败");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(result);
		response.getWriter().write(s);
		
	}

}
