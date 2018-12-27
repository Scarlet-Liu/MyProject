package com.imooc.io.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception{
		String path ="../javaDemo/demo.data";
		File file = new File(path);
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		Student stu = new Student("1001","haha",20);
//		oos.writeObject(stu);
//		oos.flush();
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu1 = (Student)ois.readObject();
		System.out.println(stu1);
		ois.close();
	}

}
