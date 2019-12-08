package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame {
	ClearPanel p = new ClearPanel();
	ClearPanel p1 = new ClearPanel(new FlowLayout());
	ClearPanel p2 = new ClearPanel(new GridLayout(2, 2, 10, 10));
	ClearPanel p3 = new ClearPanel(new GridLayout(2, 1, 5, 5));
	ClearPanel p4 = new ClearPanel();
	static ClearPanel p5 = new ClearPanel(new BorderLayout());

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
		ImagePanel panel=new ImagePanel();
		add(panel);
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
		MenuBarView menuBar = new MenuBarView(panel, panel);
		setJMenuBar(menuBar.showMenuBar());

		panel.setLayout(new BorderLayout(3, 0));

		date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DateView(panel);
			}
		});

		MandD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyDB();
			}
		});

		local.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LocalView(panel);
			}
		});

		material.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaterialView(panel);
			}
		});
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				DBconnect.close();
			}		
		});

		search.addActionListener(file.new OpenActionListener());
		commit.addActionListener(file.new CommitActionListener());
		p5.add(p3, BorderLayout.NORTH);
		p5.add(p2, BorderLayout.CENTER);
		p5.add(p4, BorderLayout.SOUTH);
		panel.add(p5);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}
}