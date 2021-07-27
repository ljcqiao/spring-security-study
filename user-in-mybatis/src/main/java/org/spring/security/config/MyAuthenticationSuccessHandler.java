package org.spring.security.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *  spring security中，专门用MyAuthenticationSuccessHandler接口来处理认证成功事项。
 *  如果spring security框架的实现，无法满足实际需要，可以自定义改实现类。
 *  在前后端分离的项目中，服务端在处理认证时，认证成功后不再是跳转到哪个页面，而是返回给前端一个登录成功的消息。
 *  如下是一个样例。
 *  
 * @author xuwen
 *
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		Map<String,String> result  = new HashMap<String,String>();
		result.put("status", "0");
		result.put("msg", "登录成功");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(result);
		response.getWriter().write(s);
	}

}
