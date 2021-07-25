# spring-security-study
springsecurity学习
1、自定义登录失败处理器
1.1、为了方便在登录失败时，给用户反馈师表信息，引入thymeleaf模板引擎。
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
1.2、新建myLogin.html
1.3、添加thymeleaf配置
	# templates文件夹的路径
	spring.thymeleaf.prefix=classpath:/static/
	# templates中的所有文件后缀名，如/static/main.html
	spring.thymeleaf.suffix=.html
1.4、添加后端请求登录失败处理器
	@RequestMapping("/myLogin")
	public String logFailure() {
		return "myLogin";
	}
1.5、修改WebSecurityCongfig
	.failureForwardUrl("/myLogin")这样在登录失败时，会请求后端/myLogin请求处理。
	这里强调一下failureUrl与failureForwardUrl的区别。
	failureUrl是重定向，是一种客户端跳转，重定向不方便携带请求失败的异常信息（只能放在 URL 中）。
	failureForwardUrl 这种跳转是一种服务器端跳转，服务器端跳转的好处是可以携带登录异常信息。如果登录失败，自动跳转回登录页面后，就可以将错误信息展示出来。
1.6、自定义AuthenticationFailure
	无论是 failureUrl 还是 failureForwardUrl，最终所配置的都是 AuthenticationFailureHandler 接口的实现。Spring Security 中提供了 AuthenticationFailureHandler 接口，用来规范登录失败的实现。

2、登出请求处理
   