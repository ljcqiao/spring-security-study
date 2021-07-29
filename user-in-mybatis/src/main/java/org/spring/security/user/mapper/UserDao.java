package org.spring.security.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.spring.security.user.Role;
import org.spring.security.user.User;
@Mapper
public interface UserDao {
	
	List<Role> getRolesByUid(Integer id);
	
    User loadUserByUsername(String username);

}