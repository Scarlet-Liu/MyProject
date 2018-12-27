package com.imooc.io;

import java.io.File;
/**
 * File��һЩ���ò�����������������˵�
 * @author Administrator
 *
 */
public class FileUtils {

	public static void main(String[] args) {
		listDirectory(new File("../JavaDemo/temp"));

	}
	/**
	 * �г�ָ��Ŀ¼�£���������Ŀ¼���������ļ�
	 * @param dir
	 */
	public static void listDirectory(File dir) {
		if(!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼"+dir+"������");
		}
		if(!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"����Ŀ¼");
		}
		//ֻ�ǰ���Ŀ¼�µ����ļ�����Ŀ¼���֣���������Ŀ¼�µ��ļ�
		String[] fileNames = dir.list();
		for( String fileName: fileNames) {
			//System.out.println(dir+"\\"+fileName);
		}
		//���Ҫ������Ŀ¼�µ��������ݣ���Ҫ����File�������ݹ������File�ṩ��ֱ�ӷ���File�����
		//���ص���ֱ����Ŀ¼�ĳ���
		File[] files = dir.listFiles();
		if(files !=null && files.length >0) {
			for(File file:files) {
				//System.out.println(file);
				if(file.isDirectory()) {
					//�ݹ�
					listDirectory(file);
				}else {
					System.out.println(file);
				}
			}
		}
		
	}

	
}
