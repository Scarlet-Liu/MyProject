package com.io.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MkDirDemo {

	public static void main(String[] args) {
		String dirName = "../JavaDemo/temp";
		// mkDir(dirName);
		//readDir(dirName);
		readFile(dirName);

	}

	/*
	 * 读文件内容并在控制台输出
	 */
	public static void readFile(String str) {
		try {
			String fileName = str + "/" + "123.txt";
			StringBuffer temp = new StringBuffer();
			String aa = null; 
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			while ((aa=br.readLine() )!= null) {
				//将读取的文件转为
				aa = new String(aa.getBytes("GBK"),"UTF-8");
				temp.append(aa);
			}
			System.out.println(temp);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 将内存中的内容写到文件中
	 */
	public static void writeFile(String str) {
		

	}

	/*
	 * 創建文件夾
	 */
	public static void mkDir(String dirName) {
		File d = new File(dirName);
		boolean result = d.mkdirs();
		if (true != result)
			System.out.println("创建目录失败");
		System.out.println("创建目录成功:" + dirName);
	}

	/*
	 * 读取目录
	 */
	public static void readDir(String dirName) {
		File fi = new File(dirName);
		if (fi.isDirectory()) {
			System.out.println("目录 " + dirName);
			String[] str = fi.list();
			for (int i = 0; i < str.length; i++) {
				File f = new File(dirName + "/" + str[i]);
				if (f.isDirectory()) {
					System.out.println(str[i] + " 是一个目录");
				} else {
					System.out.println(str[i] + " 是一个文件");
				}
			}
		} else {
			System.out.println("不是目录");
		}
	}

}
