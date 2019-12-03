package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame {
	JPanel p = new JPanel();
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel(new GridLayout(2, 2, 10, 10));
	JPanel p3 = new JPanel(new GridLayout(2, 1, 5, 5));
	JPanel p4 = new JPanel();

	JLabel label = new JLabel("��  ��  ��");
	static JLabel FileNameL = new JLabel("");
	JButton search = new JButton("ã��");
	JButton commit = new JButton("Ȯ��");
	JButton material = new JButton("������ ��");
	JButton local = new JButton("������ ��");
	JButton date = new JButton("��¥�� ��");
	JButton MandD = new JButton("��ȸ/�߰�/����/����");

	public MainView() {
		setTitle("����");
		EtchedBorder eborder;

		eborder = new EtchedBorder(EtchedBorder.RAISED);
		FileNameL.setBorder(eborder);

		FileNameL.setPreferredSize(new Dimension(450, 28));
		p2.setPreferredSize(new Dimension(10, 1));
		label.setFont(new Font("�������", Font.PLAIN, 30));
		material.setFont(new Font("�������", Font.BOLD, 20));
		local.setFont(new Font("�������", Font.BOLD, 20));
		date.setFont(new Font("�������", Font.BOLD, 20));
		MandD.setFont(new Font("�������", Font.BOLD, 20));
		p3.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		p2.setBorder(BorderFactory.createEmptyBorder(0, 100, 50, 100));
		p4.setBorder(BorderFactory.createEmptyBorder(0, 730, 0, 0));

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
		
		// ���� ������ ȣ��
		FileAct file = new FileAct();
		
		// �޴��� �߰�
		MenuBarView menuBar = new MenuBarView();
		setJMenuBar(menuBar.showMenuBar());

		super.setLayout(new BorderLayout(3, 0));

		date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DateView();
			}
		});

		MandD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyDB();
			}
		});

		local.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LocalView();
			}
		});

		material.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaterialView();
			}
		});

		search.addActionListener(file.new OpenActionListener());
		commit.addActionListener(file.new CommitActionListener());

		getContentPane().add(p3, "North");
		getContentPane().add(p2, "Center");
		getContentPane().add(p4, "South");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}
}