package go;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Local extends JFrame{
	 Local(){
		 setTitle("°í°»ÀÌ - Áö¿ªº° ºñ±³");
		
		
		 
		 setLayout(new BorderLayout());
		 
		 JPanel content=new JPanel(new GridLayout(1,2));
		 JPanel left=new JPanel(new BorderLayout());	//¿ÞÂÊ. Áö¿ªº°|±×·¡ÇÁ
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
		 
		 
		 //JPanel right=new JPanel(new GridLayout(4,1,0,20));	//¹°Áú ¼±ÅÃ, Áö¿ª ¼±ÅÃ, ³¯Â¥ ³ÖÀ» ºÎºÐ
		 JPanel right=new JPanel(new GridLayout(3,1,0,20));
		 
		 JPanel materials=new JPanel(new GridLayout(2,1));	//gas(ppm), dust(§¶)³ÖÀ» ºÎºÐ
		 
		 JPanel radioBtns=new JPanel(new GridLayout(1,2,50,0));
		 ButtonGroup rdo=new ButtonGroup();
		 JRadioButton ppm=new JRadioButton("ppm");
		 ppm.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 JRadioButton dusts=new JRadioButton("§¶");
		 dusts.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		 rdo.add(ppm);
		 rdo.add(dusts);
		 
		 radioBtns.add(ppm);
		 radioBtns.add(dusts);
		 radioBtns.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		 materials.add(radioBtns);
		 
		 JPanel chkBoxes=new JPanel(new GridLayout(1,2,0,10));	//°¡½º¿Í ¹Ì¼¼¸ÕÁö °¢ Ã¼Å©¹Ú½º¸¦ ³ÖÀ» °ø°£ÀÔ´Ï´Ù.
		 JPanel gas=new JPanel();
		 gas.setLayout(new GridLayout(4,1));
		 JCheckBox no2=new JCheckBox("ÀÌ»êÈ­Áú¼Ò");
		 no2.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 JCheckBox ozone=new JCheckBox("¿ÀÁ¸");
		 ozone.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 JCheckBox co2=new JCheckBox("ÀÌ»êÈ­Åº¼Ò");
		 co2.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 JCheckBox so2=new JCheckBox("¾ÆÈ²»ê°¡½º");
		 so2.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 
		 gas.add(no2);
		 gas.add(ozone);
		 gas.add(co2);
		 gas.add(so2);
		 
		 chkBoxes.add(gas);
		
		 
		 JPanel dust=new JPanel();
		 dust.setLayout(new GridLayout(2,1));
		 JCheckBox finedust=new JCheckBox("¹Ì¼¼¸ÕÁö");
		 finedust.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 JCheckBox ultrafinedust=new JCheckBox("ÃÊ¹Ì¼¼¸ÕÁö");
		 ultrafinedust.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		 
		 dust.add(finedust);
		 dust.add(ultrafinedust);
		
		 chkBoxes.add(dust);
		 
		 materials.add(chkBoxes);
		 right.add(materials);
		 
		 
		 JPanel regions=new JPanel(new GridLayout(4,2,0,5));
		 regions.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
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
		 
		 right.add(regions);
		 
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

		 date.add(d);
		 date.add(year);
		 date.add(month);
		 date.add(monthLabel);
		 date.add(day);
		 date.add(dayLabel);
		 
		 right.add(date);
		 content.add(right);
		 
		 add(content,BorderLayout.CENTER);
		 
		 JPanel btns=new JPanel(new GridLayout(1,2,5,0));
		 JButton apply=new JButton("Àû¿ë");
		 apply.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,12));
		 JButton help=new JButton("?");
		 help.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,12));
		 
		 btns.setBorder(BorderFactory.createEmptyBorder(0,630,10,10));
		 btns.add(apply);
		 btns.add(help);
		 
		 add(btns,BorderLayout.SOUTH);
		 
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(800,500);
		 setVisible(true);
	 }
	 
	 public static void main(String[] args) {
		 new Local();
	 }
}
