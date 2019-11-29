
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// MySql DB 연동되는 클래스와 메소드
public class DBconnect {

	// MySql DB 연동 메소드
	public Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:mysql://localhost/gogang?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "db 비밀번호";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로딩 실패");
		} catch (Exception e) {
			System.out.println("에러: " + e);
		}
		return conn;
	}

	// MySql DB 종료 메소드 1
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

	// MySql DB 종료 메소드 2
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