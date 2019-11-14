package main;
import javax.swing.*;
import java.awt.*;

public class MainView {

	static class mainView extends JFrame{
		mainView(){
			setTitle("Main View");
	
			JPanel p=new JPanel();
			JPanel p1=new JPanel(new FlowLayout());
			JPanel p2=new JPanel(new GridLayout(2,2,10,10));
			JPanel p3=new JPanel(new GridLayout(2,1,5,5));
			JPanel p4=new JPanel();
	
			JLabel label=new JLabel("��  ��  ��");
			JComboBox jbox=new JComboBox();
			JButton search=new JButton("ã��");
			JButton commit=new JButton("Ȯ��");
			JButton material=new JButton("������ ��");
			JButton local=new JButton("������ ��");
			JButton date=new JButton("��¥�� ��");
			JButton MandD=new JButton("���� �� ����");
			JButton help=new JButton("?");
	
			jbox.setPreferredSize(new Dimension(302,20));
			p2.setPreferredSize(new Dimension(10,1));
			label.setFont(new Font("�������",Font.PLAIN,30));
			material.setFont(new Font("�������",Font.BOLD,20));
			local.setFont(new Font("�������",Font.BOLD,20));
			date.setFont(new Font("�������",Font.BOLD,20));
			MandD.setFont(new Font("�������",Font.BOLD,20));
			help.setFont(new Font("�������",Font.BOLD,10));
			p3.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
			p2.setBorder(BorderFactory.createEmptyBorder(0,100,50,100));
			p4.setBorder(BorderFactory.createEmptyBorder(0,580,0,0));
	
			p.add(label);
			p1.add(jbox);
			p1.add(search);
			p1.add(commit);
			p2.add(material);
			p2.add(local);
			p2.add(date);
			p2.add(MandD);
			p3.add(p);
			p3.add(p1);
			p4.add(help);
			super.setLayout(new BorderLayout(3,0));
	
			getContentPane().add(p3,"North");
			getContentPane().add(p2,"Center");
			getContentPane().add(p4,"South");
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(650,400);
			setVisible(true);
		}
	
	
	}
	public static void main(String[] args) {
		//new mainView();
		//new MaterialView();
		new mainView();
	}

}

