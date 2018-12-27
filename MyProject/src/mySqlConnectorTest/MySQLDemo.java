package mySqlConnectorTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDemo {

	//JBDC������ �Լ����ݿ�URL
	static final String JDCB_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/runoob";
	//���ݿ��û����Լ�����
	static final String USER = "root";
	static final String PASSWORD = "*****";
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
		//ע��JDBC����
		Class.forName(JDCB_DRIVER);
		//������
		System.out.println("���ݿ�����...");
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		//ִ�в�ѯ
		System.out.println("ʵ����Statement����");
		stmt = conn.createStatement();
		String sql = "select * from websites;";
		ResultSet rs = stmt.executeQuery(sql);
		//չ�������
		while(rs.next()) {
			System.out.print("id " +rs.getInt("id") +"  ");
			System.out.print("name " +rs.getString("name")+"  ");
			System.out.println("url " +rs.getString("url"));
		}
		//��ɺ�ر���
		conn.close();
		stmt.close();
		rs.close();
		}catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
        	//�ر���Դ        	
        	if( stmt != null) stmt.close();
        	if(conn != null ) conn.close();
        	System.out.println("goodbye");
        }
	}
}
