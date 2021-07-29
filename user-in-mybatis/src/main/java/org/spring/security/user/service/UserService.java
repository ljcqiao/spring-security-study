package org.spring.security.user.service;

import java.util.List;

import org.spring.security.user.Role;
import org.spring.security.user.User;

public interface UserService {
	List<Role> getRolesByUid(Integer id);
		
	    User loadUserByUsername(String username);
	
}

