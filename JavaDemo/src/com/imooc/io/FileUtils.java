package com.imooc.io;

import java.io.File;
/**
 * File的一些常用操作，比如遍历，过滤等
 * @author Administrator
 *
 */
public class FileUtils {

	public static void main(String[] args) {
		listDirectory(new File("../JavaDemo/temp"));

	}
	/**
	 * 列出指定目录下（包括其子目录）的所有文件
	 * @param dir
	 */
	public static void listDirectory(File dir) {
		if(!dir.exists()) {
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if(!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"不是目录");
		}
		//只是包含目录下的子文件或者目录名字，不包含子目录下的文件
		String[] fileNames = dir.list();
		for( String fileName: fileNames) {
			//System.out.println(dir+"\\"+fileName);
		}
		//如果要遍历子目录下的所有内容，就要构成File对象做递归操作，File提供了直接返回File对象的
		//返回的是直接子目录的抽象
		File[] files = dir.listFiles();
		if(files !=null && files.length >0) {
			for(File file:files) {
				//System.out.println(file);
				if(file.isDirectory()) {
					//递归
					listDirectory(file);
				}else {
					System.out.println(file);
				}
			}
		}
		
	}

	
}
