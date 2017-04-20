package com.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.resultmap.mapper.OrdersMapperCustom1;
import com.resultmap.mapper.UserMapper1;
import com.resultmap.model.Orders1;
import com.resultmap.model.OrdersCustom1;
import com.resultmap.model.User1;


public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom1 ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom1.class);

		// 调用maper的方法，resultType
		List<OrdersCustom1> list = ordersMapperCustom.findOrdersUser1();

		System.out.println(list);
		sqlSession.close();
	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom1 ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom1.class);

		// 调用maper的方法，resultmap
		List<Orders1> list = ordersMapperCustom.findOrdersUserResultMap1();

		System.out.println(list);
		sqlSession.close();
	}

	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom1 ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom1.class);

		// 调用maper的方法,此处order1作为包装类即含有订单基本信息的基本字段，也有类User，list<orderDetail>作为其基本的成员变量
		//resultMap之间可以继承
		List<Orders1> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap1();

		System.out.println(list);
		sqlSession.close();
	}

	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom1 ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom1.class);

		// 调用maper的方法，一个user对弈List<order>,同一个order又对应list<orderDetail>，
		List<User1> list = ordersMapperCustom.findUserAndItemsResultMap1();

		System.out.println(list);

		sqlSession.close();
	}

	// 查询订单关联查询用户，用户信息使用延迟加载，懒加载需要sqlMapConfig.xml中设置相关参数
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
		OrdersMapperCustom1 ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom1.class);
		// 查询订单信息（单表）
		List<Orders1> list = ordersMapperCustom.findOrdersUserLazyLoading1();

		// 遍历上边的订单列表
		for (Orders1 orders : list) {
			// 执行getUser()去查询用户信息，这里实现按需加载
			User1 user = orders.getUser();
			System.out.println(user);
		}

	}

	// 一级缓存测试
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
		UserMapper1 userMapper = sqlSession.getMapper(UserMapper1.class);

		// 下边查询使用一个SqlSession
		// 第一次发起请求，查询id为1的用户
		User1 user1 = userMapper.findUserById1(1);
		System.out.println(user1);

		// 如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。

		// 更新user1的信息
		// user1.setUsername("测试用户22");
		// userMapper.updateUser(user1);
		/**
		 * 执行commit操作去清空缓存
		 */
		// sqlSession.commit();

		// 第二次发起请求，查询id为1的用户
		User1 user2 = userMapper.findUserById1(1);
		System.out.println(user2);

		sqlSession.close();

	}

	// 二级缓存测试
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper1 userMapper1 = sqlSession1.getMapper(UserMapper1.class);
		// 第一次发起请求，查询id为1的用户
		User1 user1 = userMapper1.findUserById1(1);
		System.out.println(user1);
		
		//这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
		sqlSession1.close();
		
		
//		//使用sqlSession3执行commit()操作
//		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//		User user  = userMapper3.findUserById(1);
//		user.setUsername("张明明");
//		userMapper3.updateUser(user);
//		//执行提交，清空UserMapper下边的二级缓存
//		sqlSession3.commit();
//		sqlSession3.close();
		
		

		UserMapper1 userMapper2 = sqlSession2.getMapper(UserMapper1.class);
		// 第二次发起请求，查询id为1的用户
		User1 user2 = userMapper2.findUserById1(1);
		System.out.println(user2);

		sqlSession2.close();

	}

}
