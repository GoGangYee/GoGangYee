package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class WindowCloseAction extends Frame{
	WindowCloseAction() {
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Connection conn=null;
				Statement stmt1=null;
				ResultSet rs1=null;
				int rs=0;
				String url="jdbc:mysql://localhost/airpollutiondb?characterEncoding=UTF-8&serverTimezone=UTC";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn=DriverManager.getConnection(url,"root","1569");
					//연결
					stmt1=conn.createStatement();
				
					String sql="delete from airpollutiondb";
					String sql1="select * from airpollutiondb " + 
							"into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/pollution_new.csv' " + 
							"character set utf8 " + 
							"fields terminated by ', ' " + 
							"lines terminated by '\n'";
					
					rs1=stmt1.executeQuery(sql1);
					rs=stmt1.executeUpdate(sql);
				}
				catch(ClassNotFoundException e1) {
					System.out.println("드라이버 로딩 실패");
				}
				catch(SQLException e1) {
					System.out.println("에러: "+e1);
				}
				finally {
					try {
						if(conn !=null && !conn.isClosed()) {
							conn.close();
						}
					}
				
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
		};
		this.addWindowListener(wa);
	}
}
