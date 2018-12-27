package com.io.demo;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class FileCopy {
    
    /*��������ļ��Ǵ��ı���ʹ���ַ�����������Ǵ��ı���ʹ���ֽ���*/
	public static void main(String[] args) {
		//���ļ���д������(���ԭ�������ݸ��ǵ�)
		//writeFile();
 
		//���յ����ַ���ȡ
		readByCharacter();
 
		//�����ַ����ȡ
		//readByCharacterArray();
 
		//���Ѵ��ڵ��ļ�������д(���Ḳ��ԭ�������ݵ���,ֻ��дһ��)
		//writeFileContinue();
 
		//��F�̵��ļ�������D��
		//copyFileFromFtoD();
 
		//�ַ��������Ķ�ȡ
		/*�������ĳ���ʱΪ��������Ĳ���Ч�ʶ����ֵ�.
		��Ҫ�����Ч�ʵ�����Ϊ�������ݸ��������Ĺ��캯��
		�ڻ������з�װ��һ�����飬�������ݺ�һ��ȡ��*/
		/*��ȡ�������ǣ�
				��ǰ���¹⣬���ǵ���˪��
				��ͷ�����£���ͷ˼���硣
				--���*/
		//bufferedReader();
 
		//�ַ���������д
		//bufferedWriter();
 
 
		//ý������ʱ��ͻ��õ��ֽ���
		//��F�̵�ͼƬ������D��
		//copyPictureFromDtoF();
		
		//��F�̵����ָ��Ƶ�D��
		//copyMP3FromFtoD(); 
	}
 
 
	private static void copyMP3FromFtoD() {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream("F:\\aa\\guoge.mp3");
			fo = new FileOutputStream("D:/guoge_copy.mp3");
			byte[] buf = new byte[1024];
			int n=0;
			while((n=(fi.read(buf)))!=-1){
				fo.write(buf, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fo.close();
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
 
	private static void copyPictureFromDtoF() {
		FileInputStream fi = null;
		FileOutputStream fo = null;
 
		try {
			fi = new FileInputStream("F:\\aa\\004.png");
			fo = new FileOutputStream("D:\\004_copy.png");
			byte[] buf = new byte[1024];
			int n=0;
			while((n=fi.read(buf))!=-1){
				fo.write(buf, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fo.close();
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
 
 
	private static void bufferedWriter() {
		FileWriter file = null;
		BufferedWriter bw = null;
		try {
			file = new FileWriter("F:\\aa\\bb.txt",true);
			bw = new BufferedWriter(file);
 
			//��ƽ̨�Ļ��з�
			bw.newLine();
			bw.write("���н�����������ǿ��Ϣ��");
			bw.newLine();
			bw.write("�������������Ժ�����");
			bw.newLine();
			//��������д������ˢ��
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
 
	private static void bufferedReader() {
		FileReader file = null;
		try {
			file = new FileReader("F:\\aa\\bb.txt");
 
			BufferedReader br = new BufferedReader(file);
			while(true){
				String s;
				try {
					s = br.readLine();
					if(s==null)break;
					System.out.println(s);
				} catch (IOException e) {
					e.printStackTrace();
				}
 
			}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	private static void copyFileFromFtoD() {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("D:\\test20180224.txt",true);
			fr = new FileReader("F:\\aa\\test.txt");
			char[] buf = new char[11];
			int n=0;
			while((n=fr.read(buf))!=-1){
				fw.write(new String(buf, 0, n));
				System.out.println(new String(buf, 0, n));
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	private static void writeFileContinue() {
		FileWriter file = null;
		try {
			file= new FileWriter("F:\\aa\\test.txt",true);
			file.write("(������д����)");
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
 
	private static void readByCharacter() {
		FileReader file = null;
		try {
			//����FileReader��ָ��Ҫ��ȡ���ļ�
			file = new FileReader("F:\\aa\\test.txt");
 
			int n =0;
			while((n=file.read())!=-1){
				System.out.println((char)n);
			}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	private static void readByCharacterArray() {
		FileReader file = null;
		try {
			//����FileReader��ָ��Ҫ��ȡ���ļ�
			file = new FileReader("F:\\aa\\test.txt");
			char[] buf = new char[11];
 
			int n =0;
			while((n=file.read(buf))!=-1){
				System.out.println(new String(buf,0,n));
			}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	private static void writeFile() {
		//����һ��FileWriter���󣬸ö����ʼ����ʱ���Ҫָ�����������ļ�   ���ļ������ھͻ��½�һ���ļ�
		FileWriter file = null;
		try {
			file = new FileWriter("F:\\aa\\test.txt");
			file.write("HelloWorld!");
			//ˢ�»������ݽ�����д���ļ�
			file.flush();
 
			file.write("������磡");
 
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

