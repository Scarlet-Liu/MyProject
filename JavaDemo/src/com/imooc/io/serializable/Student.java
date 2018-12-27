package com.imooc.io.serializable;

import java.io.Serializable;

public class Student implements Serializable{
	private String stuNum;
	private String stuName;
	private int age;
	public Student() {
		
	}
	public Student(String stuNum, String stuName, int age) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.age = age;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", stuName=" + stuName + ", age=" + age + "]";
	}	

}
