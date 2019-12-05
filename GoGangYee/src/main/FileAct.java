package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileAct {
	// �����ϱ� �׼Ǹ�����
	class SaveActionListener implements ActionListener {
		JFileChooser chooser;

		SaveActionListener() {
			chooser = new JFileChooser(); // ���� ���̾�α� ����
		}
		public void actionPerformed(ActionEvent e) {
			Connection conn = DBconnect.getConnection();
			Statement stmt1 = null;

			try {
				stmt1 = conn.createStatement();

				String sql = "delete from " + DBconnect.table;
				String sql1 = "select * from " + DBconnect.table
						+ " into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gogang.csv' "
						+ "character set utf8 fields terminated by ', ' lines terminated by '\n'";
				String sql2 = "drop database " + DBconnect.schema;
				String sql3 = "use " + DBconnect.table;

				System.out.println(sql1);
				System.out.println(sql);
				System.out.println(sql2);

				stmt1.executeUpdate(sql3);
				stmt1.executeQuery(sql1);
				stmt1.executeUpdate(sql);
				stmt1.executeUpdate(sql2);
			} catch (SQLException e1) {
				System.out.println(e1);
				DBconnect.close(stmt1);
			} finally {
				DBconnect.close();
			}
		}
	}

	// ������ �����ϴ� �׼Ǹ�����
	class CommitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Statement stmt = null;

			try {
				Connection conn = DBconnect.getConnection();
				stmt = conn.createStatement();
				String sql1 = "LOAD DATA INFILE '" + (MainView.FileNameL).getText()
						+ "' INTO TABLE " + DBconnect.table + " FIELDS TERMINATED BY ','";
				sql1 = sql1.replace("\\", "/");
				String sql2 = "create database " + DBconnect.schema;
				String sql3 = "use " + DBconnect.schema;
				String sql4 = "create table " + DBconnect.table
						+ "(date varchar(45) NOT NULL, local varchar(45) NOT NULL, no2 varchar(45), o3 varchar(45)"
						+ ", co2 varchar(45), so2 varchar(45), microdust varchar(45),ultrafinemicrodust varchar(45));";

				stmt.executeUpdate(sql2);
				System.out.println(sql1);
				stmt.executeUpdate(sql3);
				System.out.println(sql2);
				stmt.executeUpdate(sql4);
				System.out.println(sql3);
				stmt.executeQuery(sql1);
				System.out.println(sql4);

			} catch (SQLException e1) {
				System.out.println(e1);
			} finally {
				DBconnect.close(stmt);
			}
		}
	}
	
	// ������ �ҷ����� �׼Ǹ�����
	class OpenActionListener implements ActionListener {
		JFileChooser chooser;

		OpenActionListener() {
			chooser = new JFileChooser(); // ���� ���̾�α� ����
		}

		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { // ����ڰ� â�� ������ �ݾҰų� ��� ��ư�� ���� ���
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			}

			// ����ڰ� ������ �����ϰ� "����" ��ư�� ���� ���
			String filePath = chooser.getSelectedFile().getPath(); // ���� ��θ��� �˾ƿ´�.
			(MainView.FileNameL).setText(filePath);
			System.out.println((MainView.FileNameL).getText());
		}
	}
}
