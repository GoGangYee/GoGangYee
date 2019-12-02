
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// MySql DB 연동되는 클래스와 메소드(디자인패턴 중 싱글턴패턴)
public class DBconnect {

	// 스키마 이름과 테이블 이름 선택 참조 가능 (개인 DB정보)
	public static String schema = "gogang";
	public static String table = "gogang";
	// 알려져서는 안되는 정보들을 숨겨놓음
	private static Connection dbConn = null;
	private static String url = "jdbc:mysql://localhost/"+schema+"?characterEncoding=UTF-8&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "password";
	
	// MySql DB 연동 메소드
	public static Connection getConnection() {
		
		if(dbConn == null){
			try {
				System.out.println("DB 연결중...");
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConn = DriverManager.getConnection(url, user, password);
				System.out.println("DB 연동 완료!!");
			} catch (ClassNotFoundException e1) {
				System.out.println("드라이버 로딩 실패");
			} catch (Exception e) {
				System.out.println("에러: " + e);
			}
		} else {
			System.out.println("이미 DB연동 중...");
		}
		return dbConn;
	}

	// MySql DB 완전 종료 메소드
	public static void close() {

		if (dbConn != null) {
			try {
				dbConn.close();
				System.out.println("DB 연동 중지 완료!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		dbConn = null;
	}

	// MySql DB Statement 종료 메소드
	public static void close(Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
				System.out.println("statement 종료 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}