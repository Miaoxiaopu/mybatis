package com.soft863.www.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.soft863.www.bean.UserManager;
import com.soft863.www.mapper.UserManagerMapper;

public class TestMapperMain {
	public static void main(String[] args) throws IOException {
		InputStream inp = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inp);
		SqlSession openSession = build.openSession(true);// 设置自动提交
		UserManagerMapper userManagerMapper = openSession.getMapper(UserManagerMapper.class);
		List<UserManager> queryAll = userManagerMapper.queryAll();
		for (UserManager userManager : queryAll) {
			System.out.print(userManager.getName() + "\t");
			System.out.println(userManager.getUserType().getTypeName());
		}
	}
}
