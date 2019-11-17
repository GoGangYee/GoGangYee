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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LocalView extends JFrame{
	 LocalView(){
		 setTitle("���� - ������ ��");	
		 
		 setLayout(new BorderLayout());
		 
		 JPanel content=new JPanel(new GridLayout(1,2));
		 JPanel left=new JPanel(new BorderLayout());
		 //left.setLayout(new GridLayout(2,1));
		 JLabel name=new JLabel("��  ��  ��     ��  ��");
		 name.setFont(new Font("�������",Font.BOLD,20));
		 name.setBorder(BorderFactory.createEmptyBorder(0,90,0,0));
		 JPanel graph=new JPanel();
		 graph.setBackground(Color.BLACK);
		 graph.setPreferredSize(new Dimension(400,300));

		 left.add(name,BorderLayout.NORTH);
		 left.add(graph);
		 
		 left.setBorder(BorderFactory.createEmptyBorder(10,10,20,20));
		 content.add(left);
		 
		 
		 //JPanel right=new JPanel(new GridLayout(4,1,0,20));	//���� ����, ���� ����, ��¥ ���� �κ�
		 JPanel right=new JPanel(new GridLayout(3,1,0,20));
		 right.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		 
		 JPanel materials=new JPanel(new GridLayout(2,1));	//gas(ppm), dust(��)���� �κ�
		 
		 JPanel radioBtns=new JPanel(new GridLayout(1,2,50,0));
		 ButtonGroup rdo=new ButtonGroup();
		 JRadioButton ppm=new JRadioButton("ppm");
		 ppm.setFont(new Font("�������",Font.BOLD,15));
		 JRadioButton dusts=new JRadioButton("��");
		 dusts.setFont(new Font("�������",Font.BOLD,15));
		 rdo.add(ppm);
		 rdo.add(dusts);
		 
		 radioBtns.add(ppm);
		 radioBtns.add(dusts);
		 radioBtns.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		 materials.add(radioBtns);
		 
		 JPanel chkBoxes=new JPanel(new GridLayout(1,2,0,10));	//������ �̼����� �� üũ�ڽ��� ���� �����Դϴ�.
		 //chkBoxes.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		 JPanel gas=new JPanel();
		 gas.setLayout(new GridLayout(4,1));
		 JCheckBox no2=new JCheckBox("�̻�ȭ����");
		 no2.setFont(new Font("�������",Font.PLAIN,15));
		 JCheckBox ozone=new JCheckBox("����");
		 ozone.setFont(new Font("�������",Font.PLAIN,15));
		 JCheckBox co2=new JCheckBox("�̻�ȭź��");
		 co2.setFont(new Font("�������",Font.PLAIN,15));
		 JCheckBox so2=new JCheckBox("��Ȳ�갡��");
		 so2.setFont(new Font("�������",Font.PLAIN,15));
		 
		 gas.add(no2);
		 gas.add(ozone);
		 gas.add(co2);
		 gas.add(so2);
		 
		 chkBoxes.add(gas);
		
		 
		 JPanel dust=new JPanel();
		 dust.setLayout(new GridLayout(2,1));
		 JCheckBox finedust=new JCheckBox("�̼�����");
		 finedust.setFont(new Font("�������",Font.PLAIN,15));
		 JCheckBox ultrafinedust=new JCheckBox("�ʹ̼�����");
		 ultrafinedust.setFont(new Font("�������",Font.PLAIN,15));
		 
		 dust.add(finedust);
		 dust.add(ultrafinedust);
		
		 chkBoxes.add(dust);
		 
		 materials.add(chkBoxes);
		 right.add(materials);
		 
		 
		 JPanel regions=new JPanel(new GridLayout(4,2,0,5));
		 //regions.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		 JLabel r1=new JLabel("���� 1");
		 r1.setFont(new Font("�������",Font.BOLD,15));
		 JTextField rt1=new JTextField();
		 JLabel r2=new JLabel("���� 2");
		 r2.setFont(new Font("�������",Font.BOLD,15));
		 JTextField rt2=new JTextField();
		 JLabel r3=new JLabel("���� 3");
		 r3.setFont(new Font("�������",Font.BOLD,15));
		 JTextField rt3=new JTextField();
		 JLabel r4=new JLabel("���� 4");
		 r4.setFont(new Font("�������",Font.BOLD,15));
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
		 JLabel d=new JLabel("��¥    ");
		 d.setFont(new Font("�������",Font.BOLD,15));
		 JLabel year=new JLabel("2018��");
		 year.setFont(new Font("�������",Font.PLAIN,15));
		 JTextField month=new JTextField(5);
		 JLabel monthLabel=new JLabel("��");
		 monthLabel.setFont(new Font("�������",Font.BOLD,15));
		 JTextField day=new JTextField(5);
		 JLabel dayLabel=new JLabel("��");
		 dayLabel.setFont(new Font("�������",Font.BOLD,15));

		 //date.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		 date.add(d);
		 date.add(year);
		 date.add(month);
		 date.add(monthLabel);
		 date.add(day);
		 date.add(dayLabel);
		 
		 right.add(date);
		 content.add(right);
		 
		 add(content,BorderLayout.CENTER);
		 
		 //JPanel btns=new JPanel(new GridLayout(1,2,5,0));
		 JPanel btns=new JPanel(new FlowLayout(FlowLayout.LEFT,100,0));
		 JButton apply=new JButton("����");
		 apply.setFont(new Font("�������",Font.BOLD,13));
		 apply.setPreferredSize(new Dimension(100,28));
		 
		 JButton help=new JButton("?");
		 help.setFont(new Font("�������",Font.BOLD,13));
		 
		 btns.setBorder(BorderFactory.createEmptyBorder(0,435,5,5));
		 btns.add(apply);
		 btns.add(help);
		 
		 add(btns,BorderLayout.SOUTH);
		 
		 help.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "�̻�ȭ����\r\n" + 
							" * �ڿ� �����ڱ�\r\n" + 
							" * ȣ��⿡ ���� ����\r\n" + 
							"\r\n" + 
							"����\r\n" + 
							" * �� �ڱ�, ���۹� ����\r\n" + 
							"\r\n" + 
							"�ϻ�ȭź��\r\n" + 
							" * ��Ұ��� ����, ����, ������ ����\r\n" + 
							"\r\n" + 
							"��Ȳ�갡��\r\n" + 
							" * ��üȣ��� ��ȯ\r\n" + 
							" * �Ĺ��� ���� ����\r\n" + 
							"\r\n" + 
							"�̼�����\r\n" + 
							" * ��Ȳ�갡���� �����Ͽ� ȣ�����ȯ ����\r\n" + 
							"\r\n" + 
							"�ʹ̼�����\r\n" + 
							" * ��Ȳ�갡���� �����Ͽ� ȣ�����ȯ ����\r\n" + 
							"\r\n" + 
							"��ó - ������û","������ ����",JOptionPane.WARNING_MESSAGE);
				}
			});

		 setSize(800,500);
		 setVisible(true);
	 }
}
