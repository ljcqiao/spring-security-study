package org.spring.security.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		Map<String,String> result  = new HashMap<String,String>();
		result.put("status", "0");
		result.put("msg", "登出成功");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(result);
		response.getWriter().write(s);

	}

}
