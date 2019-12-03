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

	JLabel label = new JLabel("고  갱  이");
	static JLabel FileNameL = new JLabel("");
	JButton search = new JButton("찾기");
	JButton commit = new JButton("확인");
	JButton material = new JButton("물질별 비교");
	JButton local = new JButton("지역별 비교");
	JButton date = new JButton("날짜별 비교");
	JButton MandD = new JButton("조회/추가/수정/삭제");

	public MainView() {
		setTitle("고갱이");
		EtchedBorder eborder;

		eborder = new EtchedBorder(EtchedBorder.RAISED);
		FileNameL.setBorder(eborder);

		FileNameL.setPreferredSize(new Dimension(450, 28));
		p2.setPreferredSize(new Dimension(10, 1));
		label.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		material.setFont(new Font("맑은고딕", Font.BOLD, 20));
		local.setFont(new Font("맑은고딕", Font.BOLD, 20));
		date.setFont(new Font("맑은고딕", Font.BOLD, 20));
		MandD.setFont(new Font("맑은고딕", Font.BOLD, 20));
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
		
		// 파일 리스너 호츨
		FileAct file = new FileAct();
		
		// 메뉴바 추가
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