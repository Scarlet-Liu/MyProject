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
    
    /*如果操作文件是纯文本则使用字符流，如果不是纯文本则使用字节流*/
	public static void main(String[] args) {
		//向文件中写入数据(会把原来的数据覆盖掉)
		//writeFile();
 
		//按照单个字符读取
		readByCharacter();
 
		//按照字符组读取
		//readByCharacterArray();
 
		//对已存在的文件进行续写(不会覆盖原来的数据但是,只能写一次)
		//writeFileContinue();
 
		//将F盘的文件拷贝到D盘
		//copyFileFromFtoD();
 
		//字符缓冲流的读取
		/*缓冲区的出现时为了提高流的操作效率而出现的.
		需要被提高效率的流作为参数传递给缓冲区的构造函数
		在缓冲区中封装了一个数组，存入数据后一次取出*/
		/*读取的内容是：
				窗前明月光，疑是地上霜。
				举头望明月，低头思故乡。
				--李白*/
		//bufferedReader();
 
		//字符缓冲流的写
		//bufferedWriter();
 
 
		//媒体流的时候就会用到字节流
		//将F盘的图片拷贝到D盘
		//copyPictureFromDtoF();
		
		//将F盘的音乐复制到D盘
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
 
			//跨平台的换行符
			bw.newLine();
			bw.write("天行健，君子以自强不息；");
			bw.newLine();
			bw.write("地势坤，君子以厚德载物。");
			bw.newLine();
			//缓冲区的写必须有刷新
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
			file.write("(这是续写内容)");
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
			//创建FileReader并指定要读取的文件
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
			//创建FileReader并指定要读取的文件
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
		//创建一个FileWriter对象，该对象初始化的时候就要指定被操作的文件   该文件不存在就会新建一个文件
		FileWriter file = null;
		try {
			file = new FileWriter("F:\\aa\\test.txt");
			file.write("HelloWorld!");
			//刷新缓存数据将数据写入文件
			file.flush();
 
			file.write("你好世界！");
 
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

