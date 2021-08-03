# spring-security-study
	springsecurity学习
# 1、自定义登录失败处理器
## 1.1、为了方便在登录失败时，给用户反馈师表信息，引入thymeleaf模板引擎。
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
## 1.2、新建myLogin.html
## 1.3、添加thymeleaf配置
	# templates文件夹的路径
	spring.thymeleaf.prefix=classpath:/static/
	# templates中的所有文件后缀名，如/static/main.html
	spring.thymeleaf.suffix=.html
## 1.4、添加后端请求登录失败处理器
	@RequestMapping("/myLogin")
	public String logFailure() {
		return "myLogin";
	}
## 1.5、修改WebSecurityCongfig
	.failureForwardUrl("/myLogin")这样在登录失败时，会请求后端/myLogin请求处理。
	这里强调一下failureUrl与failureForwardUrl的区别。
	failureUrl是重定向，是一种客户端跳转，重定向不方便携带请求失败的异常信息（只能放在 URL 中）。
	failureForwardUrl 这种跳转是一种服务器端跳转，服务器端跳转的好处是可以携带登录异常信息。如果登录失败，自动跳转回登录页面后，就可以将错误信息展示出来。
## 1.6、自定义AuthenticationFailure
	无论是 failureUrl 还是 failureForwardUrl，最终所配置的都是 AuthenticationFailureHandler 接口的实现。Spring Security 中提供了 AuthenticationFailureHandler 接口，用来规范登录失败的实现。


# spring security整合mybatis
## 2.1 建表、初始化数据库

	基于mysql数据库创建用户user、角色role、用户角色关联user_role表。
	建表语句如下：
	CREATE TABLE role(
		id int(11) NOT NULL AUTO_INCREMENT,
		name varchar(32) DEFAULT NULL,
		name_china varchar(255) DEFAULT NULL,
		PRIMARY KEY (id) 
	) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;
	INSERT INTO role VALUES (1, 'ROLE_DBA', '数据库管理员');
	INSERT INTO role VALUES (2, 'ROLE_ADMIN', '系统管理员');
	INSERT INTO role VALUES (3, 'ROLE_USER', '用户');
	CREATE TABLE user(
		id int(11) NOT NULL AUTO_INCREMENT,
		username varchar(32) DEFAULT NULL,
		password varchar(255) DEFAULT NULL,
		enable int(1) DEFAULT NULL,
		account_non_expired int(1) DEFAULT NULL,
		credentials_non_expired int(1) DEFAULT NULL,
		PRIMARY KEY (id)
	) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;
	INSERT INTO user VALUES (1, 'root', '{noop}123', 1, 1, 1);
	INSERT INTO user VALUES (2, 'admin', '{noop}123', 1, 1, 1);
	INSERT INTO user VALUES (3, 'user', '{noop}123', 1, 1, 1);
	CREATE TABLE user_role(
		id int(11) NOT NULL AUTO_INCREMENT,
		uid int(11)  DEFAULT NULL,
		rid int(11)  DEFAULT NULL,
		PRIMARY KEY (id),
		KEY uid (uid),
		KEY rid (rid)
	) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;
	INSERT INTO user_role VALUES (1, 1, 1);
	INSERT INTO user_role VALUES (2, 1, 2);
	INSERT INTO user_role VALUES (3, 2, 2);
	INSERT INTO user_role VALUES (4, 3, 3);
## 2.2、引入依赖
	<!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
	<dependency>
	    <groupId>org.mybatis.spring.boot</groupId>
	    <artifactId>mybatis-spring-boot-starter</artifactId>
	    <version>2.1.3</version>
	</dependency>
	<!-- https://mvnrepository.com/artifact/MySQL/mysql-connector-java -->
	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	</dependency>
## 2.3、配置数据源
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.datasource.username=r
	spring.datasource.password=1234
	spring.datasource.url=jdbc:mysql://192.16.24.13:3306/auc?characterEncoding=utf-8
## 2.4、用户、角色对象
## 2.5、自定义UserDetailsService
# 认证流程分析
## 关键类

	
		
