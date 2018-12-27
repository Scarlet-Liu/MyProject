package com.imooc.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * 编码格式的实例
 * @author Administrator
 *
 */
public class EncodeDemo {

	public static void main(String[] args) throws IOException {
		String s = "我们ABC";
		
		//转换成字节序列用的是项目默认编码gbk
		byte[] bytes1= s.getBytes();
		for(byte b:bytes1) {
			//把字节（转换成int了）以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		//转换成gbk编码格式
		byte[] bytes2 = s.getBytes("gbk");
		for(byte b:bytes2) {
			//中gbk编码  中文占两个字节，英文占用一个字节
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		byte[] bytes3 = s.getBytes("UTF-8");
		for(byte b:bytes3) {
			//在UTF-8中中文占用三个字节，英文占用一个字节
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		//java是双字节编码 utf-16be
		byte[] bytes4 = s.getBytes("utf-16be");
		for(byte b: bytes4) {
			//utf-16be 中文占两个字节，英文占用两个字节
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		
		//当字节序列是某种编码时，这时候想要吧字节序列变成字符串也需要用同样的编码方式，否则胡出现乱码
		 String str1 = new String(bytes4,"utf-16be");
		 System.out.println(str1);
		 String str2 = new String(bytes3,"utf-8");
		 System.out.println(str2);

	}

}
