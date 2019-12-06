package main;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
 
@SuppressWarnings("serial")
class JPanel01 extends JPanel { // 1��° �г�
	public String[] region = { "������", "�������", "������", "�����Ϸ�", "���ϱ�", "������", "���״��", "���Ǳ�", "���ǻ�", "������", "���α�", "�õ�", "��õ��",
			"����", "�����", "������", "������", "���빮��", "���۱�", "������", "���빮��", "���۱�", "���۴��", "������", "���ѻ�", "���빮��", "���ʱ�",
			"������", "���ϱ�", "����", "���ı�", "������", "���̷�", "��õ��", "��������", "��������", "��걸", "����", "������", "����", "���α�", "�߱�",
			"�߶���", "õȣ���", "û��õ��", "�Ѱ����", "����", "ȫ����", "ȭ����" };
	public ButtonGroup radioBtns = new ButtonGroup(); // ���� �ߺ� ���� ���� ���� ���� ��ư
	public JRadioButton ck1 = new JRadioButton("�̻�ȭ����");
	public JRadioButton ck2 = new JRadioButton("�ϻ�ȭ���");
	public JRadioButton ck3 = new JRadioButton("��Ȳ�갡��");
	public JRadioButton ck4 = new JRadioButton("����");
	public JRadioButton ck5 = new JRadioButton("�̼�����");
	public JRadioButton ck6 = new JRadioButton("�ʹ̼�����");
	public JTextField t1 = new JTextField(2); // �� �Է�
	public JTextField t2 = new JTextField(2); // �� �Է�
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	
    public JPanelTest win;
    public JPanel p1 = new JPanel();
    public JPanel panel = new JPanel(new FlowLayout());
    public JToolBar toolBar;
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    
    public JPanel01(JPanelTest win) {
        this.win = win;
        setLayout(null);
        setLayout(new BorderLayout(10, 10));
        showForm();
		// ���� ����
		toolBar = new JToolBar("Modify ToolBar");
		toolBar.setBackground(Color.LIGHT_GRAY);
		// ��ư ����
		b1 = new JButton("��ȸ�ϱ�");
		b2 = new JButton("�߰��ϱ�");
		b3 = new JButton("�����ϱ�");
		b4 = new JButton("�����ϱ�");
		
		// ���ٿ� �޴��� ����� ������Ʈ ����
		toolBar.add(b1);
		toolBar.addSeparator();
		toolBar.add(b2);
		toolBar.addSeparator();
		toolBar.add(b3);
		toolBar.addSeparator();
		toolBar.add(b4);
		toolBar.addSeparator();
		
		// ���ٸ� �߰���.
		p1.add(toolBar);
		panel.add(p1);
		add(panel, BorderLayout.SOUTH);
        
		// ��ȸ�ϱ� ��ư�� Ŭ���ϸ� �����ϴ� ������
        b1.addActionListener(new ApplyActionListener());
        // �Է��ϱ� ��ư�� Ŭ���ϸ� �����ϴ� ������
        b2.addActionListener(new CreateActionListener());
        // �����ϱ� ��ư�� Ŭ���ϸ� �����ϴ� ������
        b3.addActionListener(new ModifyActionListener());
        // �����ϱ� ��ư�� Ŭ���ϸ� �����ϴ� ������
        b4.addActionListener(new DeleteActionListener());
    }
    
    private void showForm() {
    	JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("��ȸ�ϱ�");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("��ȸ�� �������Դϴ�.");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
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
    
    // ��ȸ�ϱ� ��ư�� Ŭ���ϸ� �ش� ���� ��ȸ��
    class ApplyActionListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    }
    
    // �Է��ϱ� ��ȯ ������
    class CreateActionListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		win.change("create");
    	}
    }
    
    // �����ϱ� ��ȯ ������
	class ModifyActionListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("modify");
        }
    }
	
	// �����ϱ� ��ȯ ������
	class DeleteActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("delete");
		}
	}
}
 
//�����ϱ� �г� Ŭ����
@SuppressWarnings("serial")
class Modify extends JPanel { 
	public String[] region = { "������", "�������", "������", "�����Ϸ�", "���ϱ�", "������", "���״��", "���Ǳ�", "���ǻ�", "������", "���α�", "�õ�", "��õ��",
			"����", "�����", "������", "������", "���빮��", "���۱�", "������", "���빮��", "���۱�", "���۴��", "������", "���ѻ�", "���빮��", "���ʱ�",
			"������", "���ϱ�", "����", "���ı�", "������", "���̷�", "��õ��", "��������", "��������", "��걸", "����", "������", "����", "���α�", "�߱�",
			"�߶���", "õȣ���", "û��õ��", "�Ѱ����", "����", "ȫ����", "ȭ����" };
	public ButtonGroup radioBtns = new ButtonGroup(); // ���� �ߺ� ���� ���� ���� ���� ��ư
	public JRadioButton ck1 = new JRadioButton("�̻�ȭ����");
	public JRadioButton ck2 = new JRadioButton("�ϻ�ȭ���");
	public JRadioButton ck3 = new JRadioButton("��Ȳ�갡��");
	public JRadioButton ck4 = new JRadioButton("����");
	public JRadioButton ck5 = new JRadioButton("�̼�����");
	public JRadioButton ck6 = new JRadioButton("�ʹ̼�����");
	public JButton apply = new JButton("��ȸ");
	public JTextField t3 = new JTextField(10); // ������ ������ �Է� ����
	public JTextField t1 = new JTextField(2); // �� �Է�
	public JTextField t2 = new JTextField(2); // �� �Է�
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	public JButton btn = new JButton("�ڷΰ���");
	public JPanelTest win;
 
    public Modify(JPanelTest win) {
        setLayout(null);
        this.win = win;
        setLayout(new BorderLayout(10,10));
        
        showForm();
        
        btn.addActionListener(new MyActionListener());
    }
    
    void showForm() {
    	JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("��ȸ�ϱ�");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
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
		E_p3.add(btn);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
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
 
    class MyActionListener implements ActionListener { // ��ư Ű ������ �г� 1�� ȣ��
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("panel01"); // �ڷΰ��� ��ư�� ������ ���ư���.
        }
    }
}

//�����ϱ� �г� Ŭ����
@SuppressWarnings("serial")
class Delete extends JPanel { 
	public String[] region = { "������", "�������", "������", "�����Ϸ�", "���ϱ�", "������", "���״��", "���Ǳ�", "���ǻ�", "������", "���α�", "�õ�", "��õ��",
			"����", "�����", "������", "������", "���빮��", "���۱�", "������", "���빮��", "���۱�", "���۴��", "������", "���ѻ�", "���빮��", "���ʱ�",
			"������", "���ϱ�", "����", "���ı�", "������", "���̷�", "��õ��", "��������", "��������", "��걸", "����", "������", "����", "���α�", "�߱�",
			"�߶���", "õȣ���", "û��õ��", "�Ѱ����", "����", "ȫ����", "ȭ����" };
	public ButtonGroup radioBtns = new ButtonGroup(); // ���� �ߺ� ���� ���� ���� ���� ��ư
	public JRadioButton ck1 = new JRadioButton("�̻�ȭ����");
	public JRadioButton ck2 = new JRadioButton("�ϻ�ȭ���");
	public JRadioButton ck3 = new JRadioButton("��Ȳ�갡��");
	public JRadioButton ck4 = new JRadioButton("����");
	public JRadioButton ck5 = new JRadioButton("�̼�����");
	public JRadioButton ck6 = new JRadioButton("�ʹ̼�����");
	public JButton apply = new JButton("��ȸ");
	public JTextField t3 = new JTextField(10); // ������ ������ �Է� ����
	public JTextField t1 = new JTextField(2); // �� �Է�
	public JTextField t2 = new JTextField(2); // �� �Է�
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	public JButton btn = new JButton("�ڷΰ���");
	public JPanelTest win;

  public Delete(JPanelTest win) {
      setLayout(null);
      this.win = win;
      setLayout(new BorderLayout(10,10));
      
      showForm();
      
      btn.addActionListener(new MyActionListener());
  }
  
  void showForm() {
  	JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("�����ϱ�");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("������ �������Դϴ�.");
		JButton b1 = new JButton("�����ϱ�");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		E_p2.add(b1);
		E_p3.add(btn);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
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

  class MyActionListener implements ActionListener { // ��ư Ű ������ �г� 1�� ȣ��
      @Override
      public void actionPerformed(ActionEvent e) {
          win.change("panel01"); // �ڷΰ��� ��ư�� ������ ���ư���.
      }
  }
}

// �߰��ϱ� �г� Ŭ����
@SuppressWarnings("serial")
class Create extends JFrame{
	public String[] region = { "������", "�������", "������", "�����Ϸ�", "���ϱ�", "������", "���״��", "���Ǳ�", "���ǻ�", "������", "���α�", "�õ�", "��õ��",
			"����", "�����", "������", "������", "���빮��", "���۱�", "������", "���빮��", "���۱�", "���۴��", "������", "���ѻ�", "���빮��", "���ʱ�",
			"������", "���ϱ�", "����", "���ı�", "������", "���̷�", "��õ��", "��������", "��������", "��걸", "����", "������", "����", "���α�", "�߱�",
			"�߶���", "õȣ���", "û��õ��", "�Ѱ����", "����", "ȫ����", "ȭ����" };
	public ButtonGroup radioBtns = new ButtonGroup(); // ���� �ߺ� ���� ���� ���� ���� ��ư
	public JRadioButton ck1 = new JRadioButton("�̻�ȭ����");
	public JRadioButton ck2 = new JRadioButton("�ϻ�ȭ���");
	public JRadioButton ck3 = new JRadioButton("��Ȳ�갡��");
	public JRadioButton ck4 = new JRadioButton("����");
	public JRadioButton ck5 = new JRadioButton("�̼�����");
	public JRadioButton ck6 = new JRadioButton("�ʹ̼�����");
	public JButton apply = new JButton("��ȸ");
	public JTextField t3 = new JTextField(10); // ������ ������ �Է� ����
	public JTextField t1 = new JTextField(2); // �� �Է�
	public JTextField t2 = new JTextField(2); // �� �Է�
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	public JButton btn = new JButton("�ڷΰ���");
	public JPanelTest win;
	
	public Create(JPanelTest win) {
		setLayout(null);
		this.win = win;
		setLayout(new BorderLayout(10,10));
	      
	    showForm();
	      
	    btn.addActionListener(new MyActionListener());
	}
	
	void showForm() {
		JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("��ȸ�ϱ�");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("��ȸ�� �������Դϴ�.");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
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
	 
	
	class MyActionListener implements ActionListener { // ��ư Ű ������ �г� 1�� ȣ��
	      @Override
	      public void actionPerformed(ActionEvent e) {
	          win.change("panel01"); // �ڷΰ��� ��ư�� ������ ���ư���.
	      }
	}
}

@SuppressWarnings("serial")
class JPanelTest extends JFrame {
 
    public JPanel01 jpanel01 = null;
    public Modify modify = null;
    public Delete delete = null;
    public Create create = null;
    
    public void change(String panelName) { // �г� 1���� 2�� ���� �� �缳��
 
        if (panelName.equals("panel01")) {
            getContentPane().removeAll();
            getContentPane().add(jpanel01);
            revalidate();
            repaint();
        } else if(panelName.equals("create")) {
            getContentPane().removeAll();
            getContentPane().add(create);
            revalidate();
            repaint();
        } else if(panelName.equals("delete")) {
            getContentPane().removeAll();
            getContentPane().add(delete);
            revalidate();
            repaint();
        } else if(panelName.equals("modify")){
            getContentPane().removeAll();
            getContentPane().add(modify);
            revalidate();
            repaint();
        } 
    }
 
}

public class PanelChangeExample extends JFrame{
	// ������
	PanelChangeExample() {
		JPanelTest win = new JPanelTest();
		
        win.setTitle("����");
        setLayout(new BorderLayout(10,10));
        win.jpanel01 = new JPanel01(win); 
        win.create = new Create(win); // �߰��ϱ� �г�
        win.modify = new Modify(win); // �����ϱ� �г�
        win.delete = new Delete(win); // �����ϱ� �г�
        
        win.add(win.jpanel01);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(800, 500);
        win.setVisible(true);
	}
	
   
}