package com.test.mapper;

import java.util.List;

import com.test.model.User1;

/**
 * 
 * <p>Title: UserMapper</p>
 * <p>Description: mapper接口，相当 于dao接口，用户管理</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-22下午2:45:12
 * @version 1.0
 */
public interface UserMapper1 {
	
	//根据用户名列查询用户列表
	public List<User1> findUserByName(String name)throws Exception;
	

	

}
