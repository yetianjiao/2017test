package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.test.mapper.UserMapper;
import com.test.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisFirst {


	// 根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest() throws Exception {
		// mybatis配置文件
		String resource = "config/SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        System.out.println("小明");
		List<User> list = mapper.findUserByName("小明");
		System.out.println(list);
		sqlSession.close();

	}
}
