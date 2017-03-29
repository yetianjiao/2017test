package com.resultmap.model;

import java.util.List;

/**
 * 
 * <p>Title: UserQueryVo</p>
 * <p>Description:包装类型 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-22下午4:24:44
 * @version 1.0
 */
public class UserQueryVo1 {
	
	//传入多个id
	private List<Integer> ids;
	
	
	//在这里包装所需要的查询条件
	
	//用户查询条件
	private UserCustom1 userCustom;

	public UserCustom1 getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom1 userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//可以包装其它的查询条件，订单、商品
	//....
	

}
