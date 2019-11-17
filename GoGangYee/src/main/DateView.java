package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DateView extends JFrame{
	DateView(){
		setTitle("DateView");
		
		String[] region = {"������","�������","������","�����Ϸ�","���ϱ�","������","���״��","���Ǳ�","���ǻ�","������","���α�","�õ�","��õ��","����","�����","������","������","���빮��","���۱�","������","���빮��","���۱�","���۴��","������","���ѻ�","���빮��","���ʱ�","������","���ϱ�","����","���ı�","������","���̷�","��õ��","��������","��������","��걸","����","������","����","���α�","�߱�","�߶���","õȣ���","û��õ��","�Ѱ����","����","ȫ����","ȭ����"};
		JPanel p=new JPanel(new BorderLayout());
		JPanel p1=new JPanel(new FlowLayout());
		JPanel p2=new JPanel(new FlowLayout());
		JPanel p3=new JPanel(new GridLayout(3,1));
		JPanel p4=new JPanel();
		JPanel p5=new JPanel(new GridLayout(2,1));
		JPanel p6=new JPanel(new GridLayout(1,2));
		
		JLabel label=new JLabel("��¥�� ��");
		JLabel LocalChooseL=new JLabel("���� ����");
		JLabel DateChooseL=new JLabel("��¥ ���� ");
		JLabel YearL=new JLabel("2018��");
		JLabel MonthL=new JLabel(" ��");
		JLabel DateL=new JLabel(" ��");
		JLabel Today=new JLabel("���� ������ ���");
		JComboBox<String> LocalChooseC=new JComboBox<>(region);
		JTextField MonthT=new JTextField(2);
		JTextField DateT=new JTextField(2);
		JButton ApplyB=new JButton("����");
		JButton HelpB=new JButton("?");
		
		LocalChooseC.setPreferredSize(new Dimension(150,25));
		label.setFont(new Font("�������",Font.PLAIN,30));
		HelpB.setFont(new Font("�������",Font.BOLD,13));
		p2.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));
		p.setBorder(BorderFactory.createEmptyBorder(10,20,0,0));
		p4.setBorder(BorderFactory.createEmptyBorder(0,730,0,0));
		p5.setBorder(BorderFactory.createEmptyBorder(0,100,60,0));
		
		p3.add(label);
		p1.add(LocalChooseL);
		p1.add(LocalChooseC);
		p1.add(ApplyB);
		p3.add(p1);
		p2.add(DateChooseL);
		p2.add(YearL);
		p2.add(MonthT);
		p2.add(MonthL);
		p2.add(DateT);
		p2.add(DateL);
		p3.add(p2);
		p.add(p3,BorderLayout.WEST);
		p5.add(Today);
		//p5.add(�����̹���) ���� �߰�
		p.add(p5,BorderLayout.CENTER);
		//p6.add(�׷���)
		//p6.add(�׷���)
		p4.add(HelpB);
		
		
		getContentPane().add(p,"North");
		//getContentPane().add(p6,"Center");
		getContentPane().add(p4,"South");
		
		HelpB.addActionListener(new ActionListener() {
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