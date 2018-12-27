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
	 * ���ļ����ݲ��ڿ���̨���
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
				//����ȡ���ļ�תΪ
				aa = new String(aa.getBytes("GBK"),"UTF-8");
				temp.append(aa);
			}
			System.out.println(temp);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * ���ڴ��е�����д���ļ���
	 */
	public static void writeFile(String str) {
		

	}

	/*
	 * �����ļ��A
	 */
	public static void mkDir(String dirName) {
		File d = new File(dirName);
		boolean result = d.mkdirs();
		if (true != result)
			System.out.println("����Ŀ¼ʧ��");
		System.out.println("����Ŀ¼�ɹ�:" + dirName);
	}

	/*
	 * ��ȡĿ¼
	 */
	public static void readDir(String dirName) {
		File fi = new File(dirName);
		if (fi.isDirectory()) {
			System.out.println("Ŀ¼ " + dirName);
			String[] str = fi.list();
			for (int i = 0; i < str.length; i++) {
				File f = new File(dirName + "/" + str[i]);
				if (f.isDirectory()) {
					System.out.println(str[i] + " ��һ��Ŀ¼");
				} else {
					System.out.println(str[i] + " ��һ���ļ�");
				}
			}
		} else {
			System.out.println("����Ŀ¼");
		}
	}

}
