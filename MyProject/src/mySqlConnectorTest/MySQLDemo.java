package mySqlConnectorTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDemo {

	//JBDC驱动名 以及数据库URL
	static final String JDCB_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/runoob";
	//数据库用户名以及密码
	static final String USER = "root";
	static final String PASSWORD = "*****";
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
		//注册JDBC驱动
		Class.forName(JDCB_DRIVER);
		//打开链接
		System.out.println("数据库链接...");
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		//执行查询
		System.out.println("实例化Statement对象");
		stmt = conn.createStatement();
		String sql = "select * from websites;";
		ResultSet rs = stmt.executeQuery(sql);
		//展开结果集
		while(rs.next()) {
			System.out.print("id " +rs.getInt("id") +"  ");
			System.out.print("name " +rs.getString("name")+"  ");
			System.out.println("url " +rs.getString("url"));
		}
		//完成后关闭流
		conn.close();
		stmt.close();
		rs.close();
		}catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
        	//关闭资源        	
        	if( stmt != null) stmt.close();
        	if(conn != null ) conn.close();
        	System.out.println("goodbye");
        }
	}
}
