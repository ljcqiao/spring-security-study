package org.spring.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 基于用户存储在mybatis的配置
 * @author xuwen
 *
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated() //任意请求都需要认证
		.and().formLogin().loginPage("/login.html")  //登录页面地址
			.loginProcessingUrl("/doLogin") //登录发送请求地址
			//.defaultSuccessUrl("/index") //默认登录成功请求
			.successHandler(new MyAuthenticationSuccessHandler()) //登录成功处理
			//.failureUrl("/myLogin.html") //登录失败跳转地址 failureUrl 表示登录失败后重定向到 mylogin.html 页面。重定向是一种客户端跳转，重定向不方便携带请求失败的异常信息（只能放在 URL 中）。
			//.failureForwardUrl("/myLogin")//failureForwardUrl 方法从名字上就可以看出，这种跳转是一种服务器端跳转，服务器端跳转的好处是可以携带登录异常信息。如果登录失败，自动跳转回登录页面后，就可以将错误信息展示出来
			.failureHandler(new MyAuthenticationFailureHandler())
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
		.and().logout().logoutUrl("/logout")
						.clearAuthentication(true)
						.invalidateHttpSession(true)
		  				.logoutSuccessHandler(new MyLogoutSuccessHandler())
		.and().csrf().disable(); //关闭csrf攻击保护
	}
	
	
}
