package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ModifyDB {
	static class modifyDB extends JFrame {
		modifyDB() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("���� �� ����");
			
			setLayout(new BorderLayout(10,10));
			showNorth();
			showWest();
			showEast();
			
			setSize(500, 330);
			setVisible(true);
			
		}
		void showNorth() {
			JPanel p1 = new JPanel();
			JPanel panel = new JPanel(new FlowLayout());
			
			JLabel lbl1 = new JLabel("���� �� ����");
			lbl1.setFont(new Font("��������", Font.PLAIN, 30));
			p1.add(lbl1);
			panel.add(p1);
			
			add(panel, BorderLayout.NORTH);
		}
		void showWest() {
			String[] region = {"������", "���ʱ�"};
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			
			JPanel p4 = new JPanel(new GridLayout(0,2));
			JPanel p5 = new JPanel(); // ���� ���� ��
			JPanel p6 = new JPanel(); // ���� ���� ���� ��ư
			JPanel p7 = new JPanel(new GridLayout(4,0)); // üũ�ڽ� 1
			JPanel p8 = new JPanel(new GridLayout(2,0)); // üũ�ڽ� 2
			
			//JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
			JPanel panel = new JPanel(new GridLayout(4,0));
			
			JLabel lbl2 = new JLabel("���� ����");
			JLabel lbl3 = new JLabel("��¥ �Է� : 2018�� ");
			JLabel month = new JLabel("��");
			JLabel day = new JLabel("��");
			JLabel lbl4 = new JLabel("���� ����");
			
			JComboBox<String> cb = new JComboBox<>(region);
			cb.setPreferredSize(new Dimension(150,20));
			
			JTextField t1 = new JTextField(2); // �� �Է�
			JTextField t2 = new JTextField(2); // �� �Է�
			
			JRadioButton rdo1 = new JRadioButton("ppm");
			JRadioButton rdo2 = new JRadioButton("��g");
			JCheckBox ck1 = new JCheckBox("�̻�ȭ����");
			JCheckBox ck2 = new JCheckBox("�ϻ�ȭ���");
			JCheckBox ck3 = new JCheckBox("��Ȳ�갡��");
			JCheckBox ck4 = new JCheckBox("����");
			JCheckBox ck5 = new JCheckBox("�̼�����");
			JCheckBox ck6 = new JCheckBox("�ʹ̼�����");
			
			p2.add(lbl2);	// ���� ����
			p2.add(cb);		// �޺� �ڽ�
			
			p3.add(lbl3);	// ��¥ �Է� : 2018�� ��
			p3.add(t1);		// �� �ؽ�Ʈ �ʵ�
			p3.add(month);
			p3.add(t2);		// �� �ؽ�Ʈ �ʵ�
			p3.add(day);
			
			p5.add(lbl4);	// ���� ����
			
			p6.add(rdo1);
			p6.add(rdo2);
			
			p7.add(ck1);
			p7.add(ck2);
			p7.add(ck3);
			p7.add(ck4);
			
			p8.add(ck5);
			p8.add(ck6);
			
			
			p4.add(p7);
			p4.add(p8);
			p5.add(p6);
			
			ButtonGroup grp = new ButtonGroup();
			grp.add(rdo1);
			grp.add(rdo2);
			
			panel.add(p2);
			panel.add(p3);
			panel.add(p5);
			
			panel.add(p4);
			
			add(panel, BorderLayout.WEST);
		}
		void showEast() {
			JPanel p1 = new JPanel(new GridLayout(3,0));
			JPanel p2 = new JPanel(new GridLayout(2,0));
			
			JPanel panel = new JPanel(new GridLayout(2,0));
			
			JLabel l1 = new JLabel("������ �����͸� �Է��ϼ���.");
			JTextField t1 = new JTextField(10); // ������ ������ �Է� ����
			JButton b1 = new JButton("����");
			
			p1.add(l1);
			p1.add(t1);
			p1.add(b1);
			
			JLabel l2 = new JLabel("�����Ϸ��� Ŭ���ϼ���.");
			JButton b2 = new JButton("����");
			
			p2.add(l2);
			p2.add(b2);
			
			p1.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
			p2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
			
			panel.add(p1);
			panel.add(p2);
			
			add(panel, BorderLayout.CENTER);
		}
	}
}