package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LocalView extends JFrame{
	 LocalView(){
		 setTitle("°í°»ÀÌ");	
		 setLayout(new BorderLayout());
		 
		 JPanel content=new JPanel(new GridLayout(1,2));
		 JPanel left=new JPanel(new BorderLayout());
		 //left.setLayout(new GridLayout(2,1));
		 JLabel name=new JLabel("Áö  ¿ª  º°     ºñ  ±³");
		 name.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		 name.setBorder(BorderFactory.createEmptyBorder(0,90,0,0));
		 JPanel graph=new JPanel();
		 graph.setBackground(Color.BLACK);
		 graph.setPreferredSize(new Dimension(400,300));

		 left.add(name,BorderLayout.NORTH);
		 left.add(graph);
		 
		 left.setBorder(BorderFactory.createEmptyBorder(10,10,20,20));
		 content.add(left);
		 
		 
		 JPanel right=new JPanel(new BorderLayout());	//¹°Áú ¼±ÅÃ, Áö¿ª ¼±ÅÃ, ³¯Â¥ ³ÖÀ» ºÎºÐ
				 
		 JPanel materials=new JPanel(new GridLayout(1,2));	//gas(ppm), dust(§¶)³ÖÀ» ºÎºÐ
		 materials.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

		 ButtonGroup radioBtns=new ButtonGroup();	//¹°Áú Áßº¹ ¼±ÅÃ ¹æÁö¸¦ À§ÇÑ ¹öÆ° ±×·ì


		 Box gas=Box.createVerticalBox();
		 JRadioButton no2=new JRadioButton("ÀÌ»êÈ­Áú¼Ò");
		 no2.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 JRadioButton ozone=new JRadioButton("¿ÀÁ¸");
		 ozone.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 JRadioButton co2=new JRadioButton("ÀÌ»êÈ­Åº¼Ò");
		 co2.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 JRadioButton so2=new JRadioButton("¾ÆÈ²»ê°¡½º");
		 so2.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 
		 radioBtns.add(no2);
		 radioBtns.add(ozone);
		 radioBtns.add(co2);
		 radioBtns.add(so2);
		 
		 gas.add(no2);
		 gas.add(ozone);
		 gas.add(co2);
		 gas.add(so2);
		 
		 materials.add(gas);
		
		 
		 Box dust=Box.createVerticalBox();
		 JRadioButton finedust=new JRadioButton("¹Ì¼¼¸ÕÁö");
		 finedust.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 JRadioButton ultrafinedust=new JRadioButton("ÃÊ¹Ì¼¼¸ÕÁö");
		 ultrafinedust.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 
		 radioBtns.add(finedust);
		 radioBtns.add(ultrafinedust);
		 
		 dust.add(finedust);
		 dust.add(ultrafinedust);
		
		gas.setBorder(new TitledBorder (new EtchedBorder(), " ppm "));
		dust.setBorder(new TitledBorder (new EtchedBorder(), " ¥ìg "));

		 materials.add(dust);
		 
		 right.add(materials,BorderLayout.NORTH);
		 
		 
		 JPanel regions=new JPanel(new GridLayout(4,2,0,5));
		 regions.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		 JLabel r1=new JLabel("Áö¿ª 1");
		 r1.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JTextField rt1=new JTextField();
		 JLabel r2=new JLabel("Áö¿ª 2");
		 r2.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JTextField rt2=new JTextField();
		 JLabel r3=new JLabel("Áö¿ª 3");
		 r3.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JTextField rt3=new JTextField();
		 JLabel r4=new JLabel("Áö¿ª 4");
		 r4.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JTextField rt4=new JTextField();
		 
		 regions.add(r1);
		 regions.add(rt1);
		 regions.add(r2);
		 regions.add(rt2);
		 regions.add(r3);
		 regions.add(rt3);
		 regions.add(r4);
		 regions.add(rt4);
		 
		 right.add(regions,BorderLayout.CENTER);
		 
		 JPanel date=new JPanel(new FlowLayout());
		 JLabel d=new JLabel("³¯Â¥    ");
		 d.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JLabel year=new JLabel("2018³â");
		 year.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 JTextField month=new JTextField(5);
		 JLabel monthLabel=new JLabel("¿ù");
		 monthLabel.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JTextField day=new JTextField(5);
		 JLabel dayLabel=new JLabel("ÀÏ");
		 dayLabel.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 
		 JButton apply=new JButton("Àû¿ë");
		 apply.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 apply.setPreferredSize(new Dimension(80,28));


		 date.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));
		 date.add(d);
		 date.add(year);
		 date.add(month);
		 date.add(monthLabel);
		 date.add(day);
		 date.add(dayLabel);
		 date.add(apply);
		 
		 right.add(date,BorderLayout.SOUTH);
		 content.add(right);
		 
		 add(content,BorderLayout.CENTER);
		 
		 
		 JPanel btns=new JPanel(new FlowLayout(FlowLayout.LEFT,100,0));
		 
		 JButton help=new JButton("?");
		 help.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		 
		 btns.setBorder(BorderFactory.createEmptyBorder(0,635,5,5));
		 btns.add(help);
		 
		 add(btns,BorderLayout.SOUTH);
		 
		 help.addActionListener(new HelpActionListener ());

		 setSize(800,500);
		 setVisible(true);
	 }
}
