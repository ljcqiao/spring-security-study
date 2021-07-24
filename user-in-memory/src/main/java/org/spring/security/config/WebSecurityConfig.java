package org.spring.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 在 Spring Security 中，如果我们需要自定义配置，基本上都是继承自 WebSecurityConfigurer
	Adapter 来实现的，当然 WebSecurityConfigurerAdapter 本身的配置还是比较复杂，同时也是比
	较丰富的。
	（1）首先 configure 方法中是一个链式配置，当然也可以不用链式配置，每一个属性配置完毕后再从 http.重新开始写起。
	（2）authorizeRequests()方法表示开启权限配置 .anyRequest().authenticated()表示所有的请求都要认证之后才能访问。
	（3）有的读者会对 and()方法表示疑惑，and()方法会返回 HttpSecurityBuilder 对象的一个
		子类（实际上就是 HttpSecurity），所以 and()方法相当于又回到 HttpSecurity 实例，重新开启
		新 一 轮 的 配 置 。 如 果 觉 得 and() 方 法 很 难 理 解 ， 也 可 以 不 用 and() 方 法 ，
		在.anyRequest().authenticated()配置完成后直接用分号（;）结束，然后通过 http.formLogin()继
		续配置表单登录。
	（4）formLogin() 表 示 开 启 表单 登录 配 置， loginPage 用 来配 置 登录页 面 地址 ；
		loginProcessingUrl 用来配置登录接口地址；defaultSuccessUrl 表示登录成功后的跳转地址；
		failureUrl 表示登录失败后的跳转地址；usernameParameter 表示登录用户名的参数名称；
		passwordParameter 表示登录密码的参数名称；
		permitAll 表示跟登录相关的页面和接口不做拦截，直接通过。需要注意的是，loginProcessingUrl、usernameParameter、passwordParameter 需 要和 login.html 中登录表单的配置一致。
	（5）最后的 csrf().disable()表示禁用 CSRF 防御功能，Spring Security 自带了 CSRF 防御
		机制，但是我们这里为了测试方便，先将 CSRF 防御机制关闭。
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated() //任意请求都需要认证
			.and().formLogin().loginPage("/login.html")  //登录页面地址
				.loginProcessingUrl("/doLogin") //登录处理请求地址
				.defaultSuccessUrl("/index") //默认登录成功请求
				.failureUrl("/login.html") //登录失败跳转地址
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
			.and().csrf().disable(); //关闭csrf攻击保护
	}
	
}
