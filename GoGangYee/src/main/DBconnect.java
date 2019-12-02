
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// MySql DB �����Ǵ� Ŭ������ �޼ҵ�(���������� �� �̱�������)
public class DBconnect {

	// ��Ű�� �̸��� ���̺� �̸� ���� ���� ���� (���� DB����)
	public static String schema = "gogang";
	public static String table = "gogang";
	// �˷������� �ȵǴ� �������� ���ܳ���
	private static Connection dbConn = null;
	private static String url = "jdbc:mysql://localhost/"+schema+"?characterEncoding=UTF-8&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "password";
	
	// MySql DB ���� �޼ҵ�
	public static Connection getConnection() {
		
		if(dbConn == null){
			try {
				System.out.println("DB ������...");
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConn = DriverManager.getConnection(url, user, password);
				System.out.println("DB ���� �Ϸ�!!");
			} catch (ClassNotFoundException e1) {
				System.out.println("����̹� �ε� ����");
			} catch (Exception e) {
				System.out.println("����: " + e);
			}
		} else {
			System.out.println("�̹� DB���� ��...");
		}
		return dbConn;
	}

	// MySql DB ���� ���� �޼ҵ�
	public static void close() {

		if (dbConn != null) {
			try {
				dbConn.close();
				System.out.println("DB ���� ���� �Ϸ�!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		dbConn = null;
	}

	// MySql DB Statement ���� �޼ҵ�
	public static void close(Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
				System.out.println("statement ���� �Ϸ�");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}