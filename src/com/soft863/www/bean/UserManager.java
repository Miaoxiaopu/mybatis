package com.soft863.www.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserManager {
	private long id;
	private String name;
	private UserEnum userType;
}
