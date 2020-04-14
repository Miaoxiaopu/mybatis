package com.soft863.www.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.soft863.www.bean.Money;
import com.soft863.www.bean.Student;
import com.soft863.www.bean.StudentClass;
import com.soft863.www.bean.User;
import com.soft863.www.bean.User2;
import com.soft863.www.bean.User3;
import com.soft863.www.bean.UserManager;
import com.soft863.www.mapper.MoneyMapper;
import com.soft863.www.mapper.UserManagerMapper;
import com.soft863.www.mapper.UserMapper;

public class TestMapper {
	InputStream inp ;
	SqlSessionFactory build;
	SqlSession openSession;
	@Before
	public void before() throws IOException{
		 inp = Resources.getResourceAsStream("SqlMapConfig.xml");
		 build = new SqlSessionFactoryBuilder().build(inp);
		 openSession = build.openSession(true);//设置自动提交
	}
	//第一种序列插入
	@org.junit.Test
	public void test1(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User user=new User();
		user.setPassword("123");
		user.setUsername("大黄蜂");
		int count = userMapper.insertUser(user);
		System.out.println(count);
		System.out.println(user.getUserId());
	}
	//第二种序列插入
	@org.junit.Test
	public void test2(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User user=new User();
		user.setPassword("456");
		user.setUsername("红蜘蛛");
		int count = userMapper.insertUser2(user);
		System.out.println(count);
		System.out.println(user.getUserId());
	}
	
	//第三种序列插入
	@org.junit.Test
	public void test3(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User2 user2=new User2();
		user2.setPassword("456");
		user2.setUsername("红蜘蛛");
		int count = userMapper.insertUser3(user2);
		System.out.println(count);
		System.out.println(user2.getUserId());
	}
	//测试连接mysql
	@Test
	public void test4(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		List<Map<String, Object>> userList = userMapper.queryUser();
		for (Map<String, Object> map : userList) {
			for (Entry<String,Object> entry: map.entrySet()) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
		}
	}
	//调用有参数存储过程
	@Test
	public void test5(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		Map map=new HashMap();
		map.put("a", 1);
		map.put("b", 2);
		userMapper.callPro(map);
		System.out.println(map.get("c"));
	}
	//调用有参数存储过程(返回多个结果)
	@Test
	public void test6(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User3 user=new User3();
		userMapper.callPro1(user);
		System.out.println(user.getUsername());	
	}
	//使用resultMap處理結果集(返回类型实体类)
	@Test
	public void test7(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		List<User3> userList = userMapper.queryByResultMap();
		System.out.println(userList.get(0).getUsername());	
	}
	//使用resultMap處理結果集(返回类型Map)
	@Test
	public void test8(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		List<Map> userList = userMapper.queryByResultMap1();
		System.out.println(userList.get(0).get("username"));	
	}
	//使用resultMap處理結果集(一对一)
	@Test
	public void test9(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		Student student = userMapper.queryStudentByStuNo(2);
		System.out.println(student);	
	}
		//使用resultMap處理結果集(一对一)
	@Test
	public void test10(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		StudentClass student = userMapper.queryStudentByClassId(1);
		System.out.println(student);	
	}	
	//测试缓存
	@Test
	public void testCache(){
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		List<Map<String, Object>> queryUser = userMapper.queryUser();
	}
	
	//测试映射枚举
	@Test
	public void testEnum(){
		UserManagerMapper userManagerMapper = openSession.getMapper(UserManagerMapper.class);
		List<UserManager> queryAll = userManagerMapper.queryAll();
//		for (UserManager userManager : queryAll) {
//			System.out.print(userManager.getName()+"\t");
//			System.out.println(userManager.getUserType().getTypeName());
//			
//		}
	}
	
	//测试映射BigDecimal
		@Test
		public void testBegDecimal(){
			MoneyMapper moneyMapper = openSession.getMapper(MoneyMapper.class);
			Money queryTotalMoney = moneyMapper.queryTotalMoney();
			System.out.println(queryTotalMoney.getMoney().compareTo(BigDecimal.ZERO));
			
		}
			
				
				
}
