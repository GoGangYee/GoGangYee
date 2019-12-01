
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// MySql DB �����Ǵ� Ŭ������ �޼ҵ�
public class DBconnect {

	// MySql DB ���� �޼ҵ�
	public Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:mysql://localhost/airpollutiondb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "ss";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			System.out.println("����: " + e);
		}
		return conn;
	}

	// MySql DB ���� �޼ҵ� 1
	public static void close(Connection conn, Statement stmt) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// MySql DB ���� �޼ҵ� 2
	public static void close(Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}