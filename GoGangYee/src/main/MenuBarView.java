package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBarView extends JFrame {
	
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem saveMI = new JMenuItem("�����ϱ�");
	JMenuItem loadMI = new JMenuItem("�ҷ�����");
	JMenuItem commitMI = new JMenuItem("�����ϱ�");
	JMenu viewMenu = new JMenu("View");
	JMenuItem backgroundMI = new JMenuItem("���ȭ�� �ٲٱ�");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem saveAir = new JMenuItem("������ȭ ������");
	JMenuItem materialInfo = new JMenuItem("������ ����");
	JMenu infoMenu = new JMenu("Info");
	JMenuItem programInfo = new JMenuItem("���α׷� ����");
	JMenuItem supportInfo = new JMenuItem("�Ŀ��ϱ�");
	JPanel panel = new JPanel();
	
	public JMenuBar showMenuBar() {
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		menuBar.add(infoMenu);
		fileMenu.add(saveMI);
		fileMenu.addSeparator(); // �и��� ����
		fileMenu.add(loadMI);
		fileMenu.add(commitMI);
		viewMenu.add(backgroundMI);
		helpMenu.add(saveAir);
		helpMenu.add(materialInfo);
		infoMenu.add(programInfo);
		infoMenu.add(supportInfo);
		
		saveMI.addActionListener(new SaveActionListener());
		loadMI.addActionListener(new OpenActionListener());
		commitMI.addActionListener(new CommitActionListener());
		return menuBar;
		
	}
}

// �����ϱ� �׼Ǹ�����
class SaveActionListener implements ActionListener {
	// ������
	SaveActionListener() {}
	// �׼�
	public void actionPerformed(ActionEvent e) {
		Connection conn = DBconnect.getConnection();
		Statement stmt1 = null;

		try {
			stmt1 =conn.createStatement();

			String sql = "delete from " + DBconnect.table;
			String sql1 = "select * from " + DBconnect.table
					+ " into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gogang.csv' "
					+ "character set utf8 " + "fields terminated by ', ' " + "lines terminated by '\n'";
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