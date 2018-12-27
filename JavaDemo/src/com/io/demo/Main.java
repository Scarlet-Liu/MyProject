package com.io.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String str = "ABC";
		writeStringToFile(str);
	}
	public static void writeStringToFile(String str) {
		File file = new File("F://demo.txt");
		FileOutputStream writFile = null;
		FileInputStream readFile = null;
		byte buffer[] = new byte[2500];
		try {
			writFile = new FileOutputStream(file);
			readFile = new FileInputStream(file);
			try {
				int a =readFile.read(buffer,1,20);
				System.out.println(a);
				writFile.write(buffer,0,a);
				
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}finally {
			try {
				writFile.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			try {
				readFile.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}

}
