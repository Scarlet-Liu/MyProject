package com.io.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取文件类
 * @author Administrator
 *
 */
public class ReadFromFile {

	public static void main(String[] args) {
		String path = "../JavaDemo/temp/hello.txt";
		readFileByBytes(path);

	}
	/*
	 * 以字节为单位读取文件，常用于读取二进制文件，入图片，声音，影像等；
	 */
	public static void readFileByBytes(String fileName) {
		File file = new File(fileName);
		InputStream ins = null;
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			ins = new FileInputStream(file);
			int tempbyte ;
			while((tempbyte = ins.read()) != -1) {
				System.out.write(tempbyte);
			}
			ins.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			byte[] by = new byte[100];			
			ins = new FileInputStream(file);
			int tempbyte ;
			while((tempbyte = ins.read(by)) != -1) {
				System.out.write(by,0,tempbyte);
			}
			ins.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	/*
	 * 以字符为单位读取文件，常用于读取文本数字等类型文件
	 */
	public static void readFileByChars(String fileName) {
		
	}
	/*
	 * 以行为单位读取文件，常用于读取面向行的文件格式
	 */
	public static void readFileByLines(String fileName) {
		
	}

}
