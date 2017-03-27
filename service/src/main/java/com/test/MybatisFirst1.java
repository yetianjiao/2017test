package com.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.mapper.UserMapper1;
import com.test.model.User1;

public class MybatisFirst1 {
	
	//对比直接使JDBC,将mysql配置和sql语句写入配置文件加载，
	//配置文件的 每一个sql语句对应的是jdbc的statement，id对应唯一的statement
	//(原始dao开发)使用session的selectOne，selectList等方法调用配置中“statement”的id来执行curd	
	//也可以封装在接口中，直接调用接口的方法即可,接口名即“statement”对应的id
	
	// 根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest1() throws Exception {
		// mybatis配置文件(db链接)
		String resource = "config/SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper1 mapper=sqlSession.getMapper(UserMapper1.class);
		List<User1> list = mapper.findUserByName("小明");
		System.out.println(list);
		sqlSession.close();

	}
}
