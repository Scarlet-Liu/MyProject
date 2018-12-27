package com.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnText {
	public static void main(String[] args) {
		Connection conn = getConnection("root", "root");
		//delete(conn);
		update(conn);
		query(conn);
		//insert(conn);
		//query_back(conn);
		releaseConnection(conn);

	}

	//��������
	public static void update(Connection conn) {
		String sql = "update websites set name ='asdas' where id = 7; ";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	// ��ѯ���ݣ����ƹ���query���� �������
	public static void query(Connection conn) {
		String sql = "select * from websites;";
		Statement st = null;
		ResultSet resultSet = null;
		try {
			st = conn.createStatement();
			resultSet = st.executeQuery(sql);
			// �����������.next()���ȵ������Ҫ�Ӻ�ǰ������resultSet.afterLast()���������һ�У�resultSet.previous
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("name") + " "
						+ resultSet.getString("url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// ��ѯ���ݣ����ƹ���query���� �������
	public static void query_back(Connection conn) {
		String sql = "select * from websites;";
		Statement st = null;
		ResultSet resultSet = null;
		try {
			st = conn.createStatement();
			resultSet = st.executeQuery(sql);
			resultSet.afterLast();
			while (resultSet.previous()) {
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("name") + " "
						+ resultSet.getString("url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	//�������
	public static void insert(Connection conn) {
		String sql = "insert into websites values (7,'abc','abcd',20,'me');";
		Statement st = null;
		boolean result = false;
		try {
			st = conn.createStatement();
			result = st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}
	}
	//ɾ������
	public static void delete(Connection conn) {
		String sql = "delete from websites where id = 6";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.execute(sql);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	// ���ݿ�����
	public static Connection getConnection(String user, String pass) {
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/runoob?"
				+ "useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8&useSSL=false";
		String userName = user;
		String passWord = pass;
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// �ͷ����ݿ�����
	public static void releaseConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
