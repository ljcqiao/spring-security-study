package org.spring.security.user.service;

import java.util.List;

import org.spring.security.user.Role;
import org.spring.security.user.User;
import org.spring.security.user.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Role> getRolesByUid(Integer id) {
		return this.userDao.getRolesByUid(id);
	}

	@Override
	public User loadUserByUsername(String username) {
		return this.userDao.loadUserByUsername(username);
	}

}
