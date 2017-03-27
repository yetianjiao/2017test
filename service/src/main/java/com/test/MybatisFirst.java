package com.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.mapper.UserMapper;
import com.test.model.User;

public class MybatisFirst {
	
	//对比直接使JDBC,将mysql配置和sql语句写入配置文件加载，
	//配置文件的 每一个sql语句对应的是jdbc的statement，id对应唯一的statement
	//使用session的selectOne，selectList等方法调用配置中“statement”的id来执行curd，也可以封装在接口中，直接调用接口的方法即可
	
	// 根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest() throws Exception {
		// mybatis配置文件(db链接)
		String resource = "config/SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper=sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findUserByName("小明");
		System.out.println(list);
		sqlSession.close();

	}
}
