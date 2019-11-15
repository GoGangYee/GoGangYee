package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MaterialView extends JFrame{

	public MaterialView() {
		setTitle("Material View");
		
		setLayout(new BorderLayout(10, 10));
		showNorth();
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
		
	}
	
	public void showNorth() {
		JPanel p1 = new JPanel(new BorderLayout());	// 지역, 날짜선택 영역
		JPanel p1_0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p1_4 = new JPanel(new GridLayout(3,1));
		JPanel p1_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// From date Choose
		JPanel p1_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// to date choose
		JPanel p1_5 = new JPanel(new GridLayout(2, 1));
		JPanel p1_6 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// From date Choose
		
		
		JPanel p2 = new JPanel();	// 물질선택 칸
		JPanel panel = new JPanel(new GridLayout(1, 2));	// 전체패널
		JPanel helpP = new JPanel();	// ?
		
		JTextField monthTF1 = new JTextField(2);
		JTextField monthTF2 = new JTextField(2);
		JTextField dayTF1 = new JTextField(2);
		JTextField dayTF2 = new JTextField(2);
		JComboBox localSelect = new JComboBox();
		JButton help = new JButton("?");
		JButton apply = new JButton("적용");
		JLabel txt1 = new JLabel("물질별 비교");
		JLabel txt2 = new JLabel("지역 선택");
		JLabel txt3 = new JLabel("날짜 선택");
		JLabel year = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel year1 = new JLabel("2018년");
		JLabel month1 = new JLabel("월");
		JLabel day1 = new JLabel("일");
		JLabel fromTo = new JLabel("~");
		
		localSelect.setPreferredSize(new Dimension(150,25));
		txt1.setFont(new Font("맑은고딕",Font.PLAIN,30));
		help.setFont(new Font("맑은고딕",Font.BOLD,13));
		p1.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));
		helpP.setBorder(BorderFactory.createEmptyBorder(0,730,0,0));
		p2.setBorder(BorderFactory.createEmptyBorder(0,100,60,0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
		
		p1.add(p1_0, BorderLayout.NORTH);	// 물질별 비교
		p1.add(p1_4, BorderLayout.CENTER);
		p1_4.add(p1_1);
//		p1_4.add(p1_2);
		p1_4.add(p1_3);
		p1_3.add(txt3);
		p1_3.add(p1_5);
		p1_0.add(txt1);
		p1_1.add(txt2);
		p1_1.add(localSelect);
		p1_1.add(apply);
		p1_2.add(txt3);
		p1_2.add(year);
		p1_2.add(monthTF1);
		p1_2.add(month);
		p1_2.add(dayTF1);
		p1_2.add(day);
		p1_6.add(fromTo);
		p1_6.add(year1);
		p1_6.add(monthTF2);
		p1_6.add(month1);
		p1_6.add(dayTF2);
		p1_6.add(day1);
		p1_5.add(p1_2);
		p1_5.add(p1_6);
		p1_3.add(txt3);
		p1_3.add(p1_5);
		helpP.add(help);	// 물음표칸
		panel.add(p1);	// 지역, 날짜선택 칸
		panel.add(p2);	// 물질선택 칸
		
		add(panel, BorderLayout.NORTH);
	}
	
	public void showSouth() {
		JPanel p1 = new JPanel();
		JLabel table = new JLabel("표입니다");
		p1.add(table);
		
		add(table, BorderLayout.SOUTH);
	}

}