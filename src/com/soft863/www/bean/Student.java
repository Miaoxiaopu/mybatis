package com.soft863.www.bean;

public class Student {
	private int stuNo;
	private String stuName;
	private int cardId;
	private StudentCard studentCard;
	public StudentCard getStudentCard() {
		return studentCard;
	}
	public void setStudentCard(StudentCard studentCard) {
		this.studentCard = studentCard;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@Override
	public String toString() {
		return "Student [stuno=" + stuNo + ", stuName=" + stuName + ", cardId=" + cardId + ", studentCard="
				+ studentCard + "]";
	}
	
}
