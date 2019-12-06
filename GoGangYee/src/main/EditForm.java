package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

// �����͸� �����Ҷ� ��Ÿ���� �г�
@SuppressWarnings("serial")
public class EditForm extends JFrame {
	
	private ModifyDB win;
	
	String[] region = { "������", "�������", "������", "�����Ϸ�", "���ϱ�", "������", "���״��", "���Ǳ�", "���ǻ�", "������", "���α�", "�õ�", "��õ��",
			"����", "�����", "������", "������", "���빮��", "���۱�", "������", "���빮��", "���۱�", "���۴��", "������", "���ѻ�", "���빮��", "���ʱ�",
			"������", "���ϱ�", "����", "���ı�", "������", "���̷�", "��õ��", "��������", "��������", "��걸", "����", "������", "����", "���α�", "�߱�",
			"�߶���", "õȣ���", "û��õ��", "�Ѱ����", "����", "ȫ����", "ȭ����" };
	ButtonGroup radioBtns = new ButtonGroup(); // ���� �ߺ� ���� ���� ���� ���� ��ư
	JRadioButton ck1 = new JRadioButton("�̻�ȭ����");
	JRadioButton ck2 = new JRadioButton("�ϻ�ȭ���");
	JRadioButton ck3 = new JRadioButton("��Ȳ�갡��");
	JRadioButton ck4 = new JRadioButton("����");
	JRadioButton ck5 = new JRadioButton("�̼�����");
	JRadioButton ck6 = new JRadioButton("�ʹ̼�����");
	JButton apply = new JButton("��ȸ");
	JTextField t3 = new JTextField(10); // ������ ������ �Է� ����
	JTextField t1 = new JTextField(2); // �� �Է�
	JTextField t2 = new JTextField(2); // �� �Է�
	JComboBox<String> cb = new JComboBox<>(region);
	JTextArea textArea = new JTextArea(1, 10);
	
	
	public EditForm(ModifyDB win){
		this.win = win;
		setTitle("test");
		setLayout(new BorderLayout(10, 10));
		
		showForm();
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	 void showForm() {
		JPanel p1 = new JPanel(new BorderLayout()); // ������¥���� + ��������
		JPanel p2 = new JPanel(new BorderLayout()); // �������� + ��¥����
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // ��������
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // ��¥����
		JPanel p4_1 = new JPanel(new FlowLayout());
		JPanel p5 = new JPanel(new BorderLayout()); // ��������
		JPanel p6 = new JPanel(); // ���� ���� ���� ��ư
		JPanel p7 = new JPanel(new GridLayout(1, 2)); // ���� ���� �ڽ� ����
		JPanel p7_0 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // �������ö�
		JPanel p7_1 = new JPanel(new BorderLayout());
		JPanel p7_2 = new JPanel(new BorderLayout());
		JPanel ppmPanel = new JPanel(new BorderLayout());
		JPanel ��gPanel = new JPanel(new BorderLayout());
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel l1 = new JLabel("������ �������Դϴ�.");
		JLabel l2 = new JLabel("���ο� �����͸� �Է��ϼ���.");
		JButton b1 = new JButton("����");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		E_p2.add(l2);
		E_p2.add(t3);
		E_p2.add(b1);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		add(Eastpanel, BorderLayout.CENTER);
		
		JLabel lbl1 = new JLabel("��¥ ����");
		JLabel lbl2 = new JLabel("���� ����");
		JLabel lbl3 = new JLabel("2018��");
		JLabel month = new JLabel("��");
		JLabel day = new JLabel("��");
		JLabel lbl4 = new JLabel("���� ����");
		
		cb.setPreferredSize(new Dimension(200, 25));
		
		Box ppm = Box.createVerticalBox();
		Box ��g = Box.createVerticalBox();
	
		radioBtns.add(ck1);
		radioBtns.add(ck2);
		radioBtns.add(ck3);
		radioBtns.add(ck4);
		radioBtns.add(ck5);
		radioBtns.add(ck6);
	
		ppmPanel.setBorder(new TitledBorder(new EtchedBorder(), " ppm "));
		��gPanel.setBorder(new TitledBorder(new EtchedBorder(), " ��g "));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
	
		Westpanel.add(p1);
		
		p1.add(p2, BorderLayout.NORTH);
		p1.add(p5, BorderLayout.CENTER);
	
		p2.add(p3, BorderLayout.NORTH);
		p2.add(p4, BorderLayout.CENTER);
		p3.add(lbl2);
		p3.add(cb);
		p4.add(lbl1);
		p4.add(p4_1);
		p4_1.add(lbl3);
		p4_1.add(t1);
		p4_1.add(month);
		p4_1.add(t2);
		p4_1.add(day);
	
		p5.add(p7_0, BorderLayout.NORTH);
		p5.add(p7, BorderLayout.CENTER);
		p5.add(apply, BorderLayout.SOUTH);
		p7.add(p7_1);
		p7.add(p7_2);
		p7_0.add(lbl4);
		p7_1.add(ppmPanel, BorderLayout.CENTER);
		p7_2.add(��gPanel, BorderLayout.CENTER);
	
		ppmPanel.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
	
		��gPanel.add(��g, BorderLayout.CENTER);
		��g.add(Box.createVerticalStrut(15));
		��g.add(ck5);
		��g.add(ck6);
	
		add(Westpanel, BorderLayout.WEST);
	}
}
