package main;

import java.awt.*;
import javax.swing.*;

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
		JPanel p1 = new JPanel(new GridLayout(0, 1));
		JPanel p1_0 = new JPanel();
		JPanel p1_1 = new JPanel();
		JPanel p1_2 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(0, 2));
		
		
		JLabel txt1 = new JLabel("물질별 비교");
		JLabel txt2 = new JLabel("지역 선택");
		JLabel txt3 = new JLabel("날짜 선택");
		JLabel year = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JTextField monthTF = new JTextField(2);
		JTextField dayTF = new JTextField(2);
		JComboBox localSelect = new JComboBox();
		
		
		p1_1.add(txt2);
		p1_1.add(localSelect);
		p1_2.add(txt3);
		p1_2.add(year);
		p1_2.add(monthTF);
		p1_2.add(day);
		p1_2.add(dayTF);
		p1_1.add(p1_2);
		p1_0.add(txt1);
		p1.add(p1_0);
		p1.add(p1_1);
		p1.add(p1_2);
		panel.add(p1);
		panel.add(p2);
		
		add(panel, BorderLayout.NORTH);
	}
	
	public void showSouth() {
		JPanel p1 = new JPanel();
		JLabel table = new JLabel("표입니다");
		p1.add(table);
		
		add(table, BorderLayout.SOUTH);
	}

}