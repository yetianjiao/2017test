package com.resultmap.mapper;

import java.util.List;

import com.resultmap.model.User1;
import com.resultmap.model.UserCustom1;
import com.resultmap.model.UserQueryVo1;

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
	
	//用户信息综合查询
	public List<UserCustom1> findUserList1(UserQueryVo1 userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	public int findUserCount1(UserQueryVo1 userQueryVo) throws Exception;
	
	//根据id查询用户信息
	public User1 findUserById1(int id) throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User1 findUserByIdResultMap1(int id) throws Exception;
	
	
	//根据用户名列查询用户列表
	public List<User1> findUserByName1(String name)throws Exception;
	
	//插入用户
	public void insertUser1(User1 user)throws Exception;
	
	//删除用户
	public void deleteUser1(int id)throws Exception;
	
	//更新用户
	public void updateUser1(User1 user)throws Exception;
	
}
