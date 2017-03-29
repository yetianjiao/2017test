package com.resultmap.mapper;

import java.util.List;

import com.resultmap.model.Orders1;
import com.resultmap.model.OrdersCustom1;
import com.resultmap.model.User1;


/**
 * 
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 订单mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-23上午10:28:43
 * @version 1.0
 */
public interface OrdersMapperCustom1 {
	
	//查询订单关联查询用户信息
	public List<OrdersCustom1> findOrdersUser1()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders1> findOrdersUserResultMap1()throws Exception;
	//查询订单(关联用户)及订单明细
	public List<Orders1>  findOrdersAndOrderDetailResultMap1()throws Exception;
	
	//查询用户购买商品信息
	public List<User1>  findUserAndItemsResultMap1()throws Exception;
	
	//查询订单关联查询用户，用户信息是延迟加载
	public List<Orders1> findOrdersUserLazyLoading1()throws Exception;

}
