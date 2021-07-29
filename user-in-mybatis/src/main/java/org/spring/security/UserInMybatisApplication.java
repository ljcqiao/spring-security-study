package org.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.spring.security"})
public class UserInMybatisApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserInMybatisApplication.class, args); 
	}
}
