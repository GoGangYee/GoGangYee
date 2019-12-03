package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame{
	JPanel p=new JPanel();
	JPanel p1=new JPanel(new FlowLayout());
	JPanel p2=new JPanel(new GridLayout(2,2,10,10));
	JPanel p3=new JPanel(new GridLayout(2,1,5,5));
	JPanel p4=new JPanel();
	
	JLabel label=new JLabel("��  ��  ��");
	JLabel FileNameL=new JLabel("");
	JButton search=new JButton("ã��");
	JButton commit=new JButton("Ȯ��");
	JButton material=new JButton("������ ��");
	JButton local=new JButton("������ ��");
	JButton date=new JButton("��¥�� ��");
	JButton MandD=new JButton("���� �� ����");
	JButton MainHelp=new JButton("?");
	
	public MainView(){
		setTitle("����");
		EtchedBorder eborder;
		
		eborder=new EtchedBorder(EtchedBorder.RAISED);
		FileNameL.setBorder(eborder);
		
		FileNameL.setPreferredSize(new Dimension(450,28));
		p2.setPreferredSize(new Dimension(10,1));
		label.setFont(new Font("�������",Font.PLAIN,30));
		material.setFont(new Font("�������",Font.BOLD,20));
		local.setFont(new Font("�������",Font.BOLD,20));
		date.setFont(new Font("�������",Font.BOLD,20));
		MandD.setFont(new Font("�������",Font.BOLD,20));
		MainHelp.setFont(new Font("�������",Font.BOLD,13));
		p3.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		p2.setBorder(BorderFactory.createEmptyBorder(0,100,50,100));
		p4.setBorder(BorderFactory.createEmptyBorder(0,730,0,0));
		
		p.add(label);
		p1.add(FileNameL);
		p1.add(search);
		p1.add(commit);
		p2.add(material);
		p2.add(local);
		p2.add(date);
		p2.add(MandD);
		p3.add(p);
		p3.add(p1);
		p4.add(MainHelp);
		
		super.setLayout(new BorderLayout(3,0));
		
		date.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new DateView();
			}
		});
		
		MandD.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ModifyDB();
			}
		});
		
		local.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new LocalView();
			}
		});
		
		material.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new MaterialView();
			}
		});
		

		search.addActionListener(new OpenActionListener());
		MainHelp.addActionListener(new MainHelpActionListener());
		commit.addActionListener(new CommitActionListener());
		
		getContentPane().add(p3,"North");
		getContentPane().add(p2,"Center");
		getContentPane().add(p4,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setVisible(true);
	
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				Connection conn=null;
				Statement stmt1=null;
	
				try {
					conn = DBconnect.getConnection();
					//����
					stmt1=conn.createStatement();
				
					String sql="delete from " + DBconnect.table;
					String sql1="select * from " + DBconnect.table +
							" into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gogang.csv' " + 
							"character set utf8 " + 
							"fields terminated by ', ' " + 
							"lines terminated by '\n'";
					String sql2="drop database "+DBconnect.schema;
					String sql3="use "+DBconnect.table;
					
					System.out.println(sql1);
					System.out.println(sql);
					System.out.println(sql2);
					
					stmt1.executeUpdate(sql3);
					stmt1.executeQuery(sql1);
					stmt1.executeUpdate(sql);
					stmt1.executeUpdate(sql2);
				}
				catch(SQLException e1) {
					System.out.println(e1);
					DBconnect.close(stmt1);
				}
			}		
		});
	}
	
	
	
	class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		
		OpenActionListener() {
			chooser = new JFileChooser(); // ���� ���̾�α� ����
		}
		
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { // ����ڰ� â�� ������ �ݾҰų� ��� ��ư�� ���� ���
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// ����ڰ� ������ �����ϰ� "����" ��ư�� ���� ���
			String filePath = chooser.getSelectedFile().getPath(); // ���� ��θ��� �˾ƿ´�.
			FileNameL.setText(filePath);
			System.out.println(FileNameL.getText());
		}
	}
	

	class CommitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Connection conn=null;
			Statement stmt=null;
			
			try {
				conn = DBconnect.getConnection();
				//����
				stmt=conn.createStatement();
				String sql1="LOAD DATA INFILE '";
				sql1+=FileNameL.getText();
				sql1+="' INTO TABLE " + DBconnect.table + " FIELDS TERMINATED BY ','";
				sql1=sql1.replace("\\","/");				
				String sql2="create database "+DBconnect.schema;
				String sql3="use "+DBconnect.schema;
				String sql4="create table "+DBconnect.table+"(date varchar(45) NOT NULL, local varchar(45) NOT NULL, no2 varchar(45), o3 varchar(45)" + 
						", co2 varchar(45), so2 varchar(45), microdust varchar(45),ultrafinemicrodust varchar(45));";
				
				
				stmt.executeUpdate(sql2);
				System.out.println(sql1);
				stmt.executeUpdate(sql3);
				System.out.println(sql2);
				stmt.executeUpdate(sql4);
				System.out.println(sql3);
				stmt.executeQuery(sql1);
				System.out.println(sql4);
				
			} catch (Exception e1) {
				System.out.println(e1);
				DBconnect.close(stmt);
			}
		}
	}
}