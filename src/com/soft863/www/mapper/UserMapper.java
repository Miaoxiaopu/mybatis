package com.soft863.www.mapper;

import java.util.List;
import java.util.Map;

import com.soft863.www.bean.Student;
import com.soft863.www.bean.StudentClass;
import com.soft863.www.bean.User;
import com.soft863.www.bean.User2;
import com.soft863.www.bean.User3;

public interface UserMapper {
	public int insertUser(User user);
	public int insertUser2(User user);
	public int insertUser3(User2 user);
	public List<Map<String,Object>> queryUser();
	public void callPro(Map map);
	public void callPro1(User3 user);
	public List<User3> queryByResultMap();
	public List<Map> queryByResultMap1();
	public Student queryStudentByStuNo(int stuNo);
	public StudentClass queryStudentByClassId(int classId);

}
