package com.imooc.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * �����ʽ��ʵ��
 * @author Administrator
 *
 */
public class EncodeDemo {

	public static void main(String[] args) throws IOException {
		String s = "����ABC";
		
		//ת�����ֽ������õ�����ĿĬ�ϱ���gbk
		byte[] bytes1= s.getBytes();
		for(byte b:bytes1) {
			//���ֽڣ�ת����int�ˣ���16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		//ת����gbk�����ʽ
		byte[] bytes2 = s.getBytes("gbk");
		for(byte b:bytes2) {
			//��gbk����  ����ռ�����ֽڣ�Ӣ��ռ��һ���ֽ�
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		byte[] bytes3 = s.getBytes("UTF-8");
		for(byte b:bytes3) {
			//��UTF-8������ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		//java��˫�ֽڱ��� utf-16be
		byte[] bytes4 = s.getBytes("utf-16be");
		for(byte b: bytes4) {
			//utf-16be ����ռ�����ֽڣ�Ӣ��ռ�������ֽ�
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		//���ֽ�������ĳ�ֱ���ʱ����ʱ����Ҫ���ֽ����б���ַ���Ҳ��Ҫ��ͬ���ı��뷽ʽ���������������
		 String str1 = new String(bytes4,"utf-16be");
		 System.out.println(str1);
		 String str2 = new String(bytes3,"utf-8");
		 System.out.println(str2);

	}

}
