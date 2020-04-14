package com.soft863.www.bean;

public enum UserEnum{
	MANAGER_USER_TYPE("管理员"),
	NORMAL_USER_TYPE("普通用户");
			
	private String userType;
	
	private UserEnum(String userType){
		
		this.userType = userType;
	}
	
	public String getEnumName(){ 
		return this.name();
	}
	
	public String getTypeName(){
		return this.userType;
	}

}
