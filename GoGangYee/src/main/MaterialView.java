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
		setSize(650, 400);
		setVisible(true);
		
	}
	
	public void showNorth() {
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p1_1 = new JPanel(new GridLayout(0, 2));
		JPanel p1_1_1 = new JPanel(new GridLayout(0, 5));
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(0, 2));
		
		
		JLabel txt1 = new JLabel("물질별 비교");
		JLabel txt2 = new JLabel("지역 선택");
		JLabel txt3 = new JLabel("날짜 선택");
		JLabel year = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JTextField monthTF = new JTextField();
		JComboBox localSelect = new JComboBox();
		
		p1_1_1.add(year);
		p1_1_1.add(monthTF);
		p1_1.add(txt2);
		p1_1.add(localSelect);
		p1_1.add(txt3);
		p1_1.add(p1_1_1);
		p1.add("North", txt1);
		p1.add("South", p1_1);
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