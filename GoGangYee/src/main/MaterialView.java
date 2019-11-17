package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MaterialView extends JFrame{

	public MaterialView() {
		setTitle("Material View");
		
		setLayout(new BorderLayout(10, 10));
		showNorth();
		showCenter();
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
		
	}
	
	public void showNorth() {
		JPanel p1 = new JPanel(new BorderLayout());	// 지역, 날짜선택 영역
		JPanel p1_0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p1_4 = new JPanel(new BorderLayout());
		JPanel p1_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// From date Choose
		JPanel p1_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// to date choose
		JPanel p1_5 = new JPanel(new BorderLayout());
		JPanel p1_6 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// From date Choose
		JPanel p1_7 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new BorderLayout());	// 물질선택 칸
		JPanel p2_0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2_1 = new JPanel(new BorderLayout());	// 물질 선택 왼쪽
		JPanel p2_2 = new JPanel(new BorderLayout());	// 물질 선택 오른쪽
		JPanel p2_1_1 = new JPanel(new BorderLayout());
		JPanel p2_2_1 = new JPanel(new BorderLayout());
		JPanel p2_3 = new JPanel(new GridLayout(1,2));
		JPanel panel = new JPanel(new GridLayout(1,2));	// 전체패널
		
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
		JLabel materialChoice = new JLabel("물질 선택");
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
        JCheckBox ck1 = new JCheckBox("이산화질소");
        JCheckBox ck2 = new JCheckBox("일산화산소");
        JCheckBox ck3 = new JCheckBox("아황산가스");
        JCheckBox ck4 = new JCheckBox("오존");
        JCheckBox ck5 = new JCheckBox("미세먼지");
        JCheckBox ck6 = new JCheckBox("초미세먼지");
		
		localSelect.setPreferredSize(new Dimension(200,25));
		txt1.setFont(new Font("맑은고딕",Font.PLAIN,30));
		help.setFont(new Font("맑은고딕",Font.BOLD,13));
		p2_1_1.setBorder(new TitledBorder (new EtchedBorder(), " ppm "));
		p2_2_1.setBorder(new TitledBorder (new EtchedBorder(), " μg "));
		p2.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		p1.add(p1_0, BorderLayout.NORTH);
		p1.add(p1_4, BorderLayout.CENTER);
		p1_4.add(p1_1, BorderLayout.NORTH);
		p1_4.add(p1_7, BorderLayout.CENTER);
		p1_7.add(p1_3, BorderLayout.WEST);
		p1_7.add(p1_5, BorderLayout.CENTER);
		p1_5.add(p1_2, BorderLayout.NORTH);
		p1_5.add(p1_6, BorderLayout.CENTER);
		p1_0.add(txt1);
		p1_1.add(txt2);
		p1_1.add(localSelect);
		p1_3.add(txt3);
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
		
		p2.add(p2_0, BorderLayout.NORTH);
		p2.add(p2_3, BorderLayout.CENTER);
		p2.add(apply, BorderLayout.SOUTH);
		p2_0.add(materialChoice);
		p2_1.add(p2_1_1, BorderLayout.CENTER);
		p2_2.add(p2_2_1, BorderLayout.CENTER);
		p2_1_1.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
		p2_2_1.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
		p2_3.add(p2_1);
		p2_3.add(p2_2);
		
		panel.add(p1);	// 지역, 날짜선택 칸
		panel.add(p2);	// 물질선택 칸
		
		add(panel, BorderLayout.NORTH);
	}
	
	public void showCenter() {
		JPanel p1 = new JPanel();
		JLabel table = new JLabel("표입니다");
		p1.add(table);
		
		add(table, BorderLayout.CENTER);
	}
	
	public void showSouth() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton helpB = new JButton("?");
		
		helpB.setFont(new Font("맑은고딕", Font.BOLD, 13));
		
		panel.add(helpB);
		
		add(panel, BorderLayout.SOUTH);
	}

}