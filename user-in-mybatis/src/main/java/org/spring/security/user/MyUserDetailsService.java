package org.spring.security.user;


import org.spring.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =  this.userService.loadUserByUsername(username);
		if(null==user) {
			throw new UsernameNotFoundException("用户未找到");
		}
		user.setRoles(this.userService.getRolesByUid(user.getId()));
		return user;
	}

}
