package com.io.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ��ȡ�ļ���
 * @author Administrator
 *
 */
public class ReadFromFile {

	public static void main(String[] args) {
		String path = "../JavaDemo/temp/hello.txt";
		readFileByBytes(path);

	}
	/*
	 * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ�ȡ�������ļ�����ͼƬ��������Ӱ��ȣ�
	 */
	public static void readFileByBytes(String fileName) {
		File file = new File(fileName);
		InputStream ins = null;
		try {
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
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
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
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
	 * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ�ȡ�ı����ֵ������ļ�
	 */
	public static void readFileByChars(String fileName) {
		
	}
	/*
	 * ����Ϊ��λ��ȡ�ļ��������ڶ�ȡ�����е��ļ���ʽ
	 */
	public static void readFileByLines(String fileName) {
		
	}

}
