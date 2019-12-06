package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        win.setBackground(Color.WHITE);
        setLayout(null);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));
        showForm();
        // �޴��� ����
        MenuBarView menuBar = new MenuBarView();
        add(menuBar.showMenuBar(), BorderLayout.NORTH);
      // ���� ����
      toolBar = new JToolBar("Modify ToolBar");
      toolBar.setBackground(Color.WHITE);
      // ��ư �� ����
      JLabel addiconlabel = new JLabel("�߰��ϱ�");
      JLabel findiconlabel = new JLabel("��ȸ�ϱ�");
      JLabel modifyiconlabel = new JLabel("�����ϱ�");
      JLabel deleteiconlabel = new JLabel("�����ϱ�");
      // ������ ����
      ImageIcon addicon = new ImageIcon("image/addicon.png");
      ImageIcon findicon = new ImageIcon("image/findicon.png");
      ImageIcon modifyicon = new ImageIcon("image/modifyicon.png");
      ImageIcon deleteicon = new ImageIcon("image/deleteicon.png");
      
      // ��ư ����
      b1 = new JButton(findicon);
      b2 = new JButton(addicon);
      b3 = new JButton(modifyicon);
      b4 = new JButton(deleteicon);
      
      // ���ٿ� �޴��� ����� ������Ʈ ����
      toolBar.add(b1);
      toolBar.addSeparator();
      toolBar.add(findiconlabel);
      toolBar.addSeparator();
      
      toolBar.add(b2);
      toolBar.addSeparator();
      toolBar.add(addiconlabel);
      toolBar.addSeparator();
      
      toolBar.add(b3);
      toolBar.addSeparator();
      toolBar.add(modifyiconlabel);
      toolBar.addSeparator();
      
      toolBar.add(b4);
      toolBar.addSeparator();
      toolBar.add(deleteiconlabel);
      toolBar.addSeparator();
      
      // ���ٸ� �߰���.
      p1.add(toolBar);
      panel.add(p1);
      p1.setBackground(Color.WHITE);
      panel.setBackground(Color.WHITE);
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
      p1.setBackground(Color.WHITE);
      p2.setBackground(Color.WHITE);
      p3.setBackground(Color.WHITE);
      p4.setBackground(Color.WHITE);
      p4_1.setBackground(Color.WHITE);
      p5.setBackground(Color.WHITE);
      p6.setBackground(Color.WHITE);
      p7.setBackground(Color.WHITE);
      p7_0.setBackground(Color.WHITE);
      p7_1.setBackground(Color.WHITE);
      p7_2.setBackground(Color.WHITE);
      //ppmPanel.setBackground(Color.WHITE);
      //��gPanel.setBackground(Color.WHITE);
      Westpanel.setBackground(Color.WHITE);
      
      
      JPanel Eastpanel = new JPanel(new GridLayout(4,0));
      JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      Eastpanel.setBackground(Color.WHITE);
      E_p1.setBackground(Color.WHITE);
      E_p2.setBackground(Color.WHITE);
      E_p3.setBackground(Color.WHITE);
      E_p4.setBackground(Color.WHITE);
      
      JPanel Northpanel = new JPanel(new GridLayout(1,0));
      Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
      JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JLabel title = new JLabel("Find Data");
      title.setFont(new Font("���ü", Font.PLAIN, 30));
      Title.add(title);
      Northpanel.add(Title);
      add(Northpanel, BorderLayout.CENTER);
      
      Northpanel.setBackground(Color.WHITE);
      Title.setBackground(Color.WHITE);
      
      JLabel l1 = new JLabel("������ ��ȸ�� �������Դϴ�.");
      JLabel l2 = new JLabel("��ȸ�ϱ� ��ư�� ������ �ش� ���� ��ȸ�մϴ�.\n");
      textArea.setEditable(false);
      Eastpanel.setBorder(BorderFactory.createEmptyBorder(55, 30, 150, 10));
      E_p1.add(title);
      E_p2.add(l2);
      E_p3.add(l1);
      E_p4.add(textArea);
      Eastpanel.add(E_p1);
      Eastpanel.add(E_p2);
      Eastpanel.add(E_p3);
      Eastpanel.add(E_p4);
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
      p1.setBorder(BorderFactory.createEmptyBorder(80, 70, 0, 0));
   
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
            if(t1.getText().equals("")==true||t2.getText().equals("")==true||(ck1.isSelected()==false&&ck2.isSelected()==false&&ck3.isSelected()==false&&ck4.isSelected()==false&&ck5.isSelected()==false&&ck6.isSelected()==false))
          {
             JOptionPane.showMessageDialog(null,"���� ��� �Էµ��� �ʾҰų� üũ���� �ʾҽ��ϴ�!");
          }
            else
            {
             String material = "";
             String data = "";
             Connection conn = DBconnect.getConnection();
             Statement stmt = null;
             ResultSet rs = null;

             if (ck1.isSelected()) {
                material = "no2";
             }
             if (ck2.isSelected()) {
                material = "o3";
             }
             if (ck3.isSelected()) {
                material = "co2";
             }
             if (ck4.isSelected()) {
                material = "so2";
             }
             if (ck5.isSelected()) {
                material = "microdust";
             }
             if (ck6.isSelected()) {
                material = "ultrafinemicrodust";
             }

             data = material + "=";

             try {
                stmt = conn.createStatement();

                String sql = "select " + material + " from " + DBconnect.table + " where " + "date='" + "2018"
                      + t1.getText() + t2.getText() + "' and local='" + cb.getSelectedItem().toString() + "'";

                System.out.println(sql);
                rs = stmt.executeQuery(sql);

                if (rs.next()) {
                   data += rs.getString(material);
                   if (data.equals("")) {
                      data = "0";
                   }
                }
                System.out.println(data);
             } catch (SQLException e1) {
                e1.printStackTrace();
             } finally {
                DBconnect.close(stmt);
                textArea.setText(data);
             }
          }
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
   public JButton b1 = new JButton("�����ϱ�");
   public JButton btn = new JButton("�ڷΰ���");
   public JPanelTest win;
 
    public Modify(JPanelTest win) {
        setLayout(null);
        this.win = win;
        setLayout(new BorderLayout(10,10));
        win.setBackground(Color.WHITE);
        setBackground(Color.WHITE);
        showForm();
        // �޴��� ����
        MenuBarView menuBar = new MenuBarView();
        add(menuBar.showMenuBar(), BorderLayout.NORTH);
        
        btn.addActionListener(new MyActionListener());
        apply.addActionListener(new ApplyActionListener());
        b1.addActionListener(new ModifyActionListener());
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
      p1.setBackground(Color.WHITE);
      p2.setBackground(Color.WHITE);
      p3.setBackground(Color.WHITE);
      p4.setBackground(Color.WHITE);
      p4_1.setBackground(Color.WHITE);
      p5.setBackground(Color.WHITE);
      p6.setBackground(Color.WHITE);
      p7.setBackground(Color.WHITE);
      p7_0.setBackground(Color.WHITE);
      p7_1.setBackground(Color.WHITE);
      p7_2.setBackground(Color.WHITE);
      //ppmPanel.setBackground(Color.WHITE);
      //��gPanel.setBackground(Color.WHITE);
      Westpanel.setBackground(Color.WHITE);
      
      
      
      JPanel Eastpanel = new JPanel(new GridLayout(4,0));
      JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      Eastpanel.setBackground(Color.WHITE);
      E_p1.setBackground(Color.WHITE);
      E_p2.setBackground(Color.WHITE);
      E_p3.setBackground(Color.WHITE);
      E_p4.setBackground(Color.WHITE);
      
      JPanel Northpanel = new JPanel(new GridLayout(1,0));
      Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
      Northpanel.setBackground(Color.WHITE);
      JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
      Title.setBackground(Color.WHITE);
      JLabel title = new JLabel("Modify Data");
      title.setFont(new Font("���ü", Font.PLAIN, 30));
      Title.add(title);
      Northpanel.add(Title);
      add(Northpanel, BorderLayout.CENTER);
      
      JLabel l1 = new JLabel("������ �������Դϴ�.");
      JLabel l2 = new JLabel("���ο� �����͸� �Է��ϼ���.");
      
      textArea.setEditable(false);
      Eastpanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 150, 10));
      E_p1.add(title);
      E_p2.add(l1);
      E_p2.add(textArea);
      E_p3.add(l2);
      E_p3.add(t3);
      E_p4.add(b1);
      E_p4.add(btn);
      Eastpanel.add(E_p1);
      Eastpanel.add(E_p2);
      Eastpanel.add(E_p3);
      Eastpanel.add(E_p4);
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
      p1.setBorder(BorderFactory.createEmptyBorder(80, 70, 0, 0));
   
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
    class ModifyActionListener implements ActionListener { // �����ϱ� ��ư �׼� ������
        @Override
        public void actionPerformed(ActionEvent e) {
           if(t1.getText().equals("")==true||t2.getText().equals("")==true||t3.getText().equals("")==true||(ck1.isSelected()==false&&ck2.isSelected()==false&&ck3.isSelected()==false&&ck4.isSelected()==false&&ck5.isSelected()==false&&ck6.isSelected()==false))
           {
              JOptionPane.showMessageDialog(null,"���� ��� �Էµ��� �ʾҰų� üũ���� �ʾҽ��ϴ�!");
           }
           else
           {
              String material = "";
              Connection conn = DBconnect.getConnection();
              Statement stmt = null;
              int rs = 0;

              if (ck1.isSelected()) {
                 material = "no2";
              }
              if (ck2.isSelected()) {
                 material = "o3";
              }
              if (ck3.isSelected()) {
                 material = "co2";
              }
              if (ck4.isSelected()) {
                 material = "so2";
              }
              if (ck5.isSelected()) {
                 material = "microdust";
              }
              if (ck6.isSelected()) {
                 material = "ultrafinemicrodust";
              }

              try {
                 stmt = conn.createStatement();

                 String sql = "update " + DBconnect.table + " set " + material + "=" + t3.getText()
                 + " where date='2018" + t1.getText() + t2.getText() + "' and local='"
                 + cb.getSelectedItem().toString() + "'";

               System.out.println(sql);
               rs = stmt.executeUpdate(sql);JOptionPane.showMessageDialog(null,"���� �Ϸ�!");
              } catch (SQLException e1) {
                 e1.printStackTrace();
            }
           }
   }
   }
 // ��ȸ�ϱ� ��ư�� Ŭ���ϸ� �ش� ���� ��ȸ��
    class ApplyActionListener implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent e) {
            if(t1.getText().equals("")==true||t2.getText().equals("")==true||(ck1.isSelected()==false&&ck2.isSelected()==false&&ck3.isSelected()==false&&ck4.isSelected()==false&&ck5.isSelected()==false&&ck6.isSelected()==false))
          {
             JOptionPane.showMessageDialog(null,"���� ��� �Էµ��� �ʾҰų� üũ���� �ʾҽ��ϴ�!");
          }
            else
            {
             String material = "";
             String data = "";
             Connection conn = DBconnect.getConnection();
             Statement stmt = null;
             ResultSet rs = null;

             if (ck1.isSelected()) {
                material = "no2";
             }
             if (ck2.isSelected()) {
                material = "o3";
             }
             if (ck3.isSelected()) {
                material = "co2";
             }
             if (ck4.isSelected()) {
                material = "so2";
             }
             if (ck5.isSelected()) {
                material = "microdust";
             }
             if (ck6.isSelected()) {
                material = "ultrafinemicrodust";
             }

             data = material + "=";

             try {
                stmt = conn.createStatement();

                String sql = "select " + material + " from " + DBconnect.table + " where " + "date='" + "2018"
                      + t1.getText() + t2.getText() + "' and local='" + cb.getSelectedItem().toString() + "'";

                System.out.println(sql);
                rs = stmt.executeQuery(sql);

                if (rs.next()) {
                   data += rs.getString(material);
                   if (data.equals("")) {
                      data = "0";
                   }
                }
                System.out.println(data);
             } catch (SQLException e1) {
                e1.printStackTrace();
             } finally {
                DBconnect.close(stmt);
                textArea.setText(data);
             }
          }
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
   public JButton b1 = new JButton("�����ϱ�");
   public JButton btn = new JButton("�ڷΰ���");
   public JPanelTest win;
   
  public Delete(JPanelTest win) {
      setLayout(null);
      this.win = win;
      setLayout(new BorderLayout(10,10));
      setBackground(Color.WHITE);
      showForm();
     // �޴��� ����
     MenuBarView menuBar = new MenuBarView();
     add(menuBar.showMenuBar(), BorderLayout.NORTH);
      btn.addActionListener(new MyActionListener());
      apply.addActionListener(new ApplyActionListener());
      b1.addActionListener(new DeleteActionListener());
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
      
      JPanel Eastpanel = new JPanel(new GridLayout(4,0));
      JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      
      p1.setBackground(Color.WHITE);
      p2.setBackground(Color.WHITE);
      p3.setBackground(Color.WHITE);
      p4.setBackground(Color.WHITE);
      p4_1.setBackground(Color.WHITE);
      p5.setBackground(Color.WHITE);
      p5.setBackground(Color.WHITE);
      p7.setBackground(Color.WHITE);
      p7_0.setBackground(Color.WHITE);
      p7_1.setBackground(Color.WHITE);
      p7_2.setBackground(Color.WHITE);
      //ppmPanel.setBackground(Color.WHITE);
      Westpanel.setBackground(Color.WHITE);
      Eastpanel.setBackground(Color.WHITE);
      E_p1.setBackground(Color.WHITE);
      E_p2.setBackground(Color.WHITE);
      E_p3.setBackground(Color.WHITE);
      E_p4.setBackground(Color.WHITE);
      
      JPanel Northpanel = new JPanel(new GridLayout(1,0));
      Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
      JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JLabel title = new JLabel("Delete Data");
      title.setFont(new Font("���ü", Font.PLAIN, 30));
      Title.add(title);
      Northpanel.add(Title);
      add(Northpanel, BorderLayout.CENTER);

      JLabel l1 = new JLabel("������ �������Դϴ�.");
      JLabel l2 = new JLabel("�����Ϸ��� �����ϱ� ��ư�� Ŭ���ϼ���.");
      
      textArea.setEditable(false);
      Eastpanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 150, 10));
      E_p1.add(title);
      E_p2.add(l2);
      E_p3.add(l1);
      E_p3.add(textArea);
      E_p4.add(b1);  // �����ϱ� ��ư
      E_p4.add(btn); // �ڷΰ��� ��ư
      Eastpanel.add(E_p1);
      Eastpanel.add(E_p2);
      Eastpanel.add(E_p3);
      Eastpanel.add(E_p4);
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
      p1.setBorder(BorderFactory.createEmptyBorder(80, 70, 0, 0));
   
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
  
  class DeleteActionListener implements ActionListener { // ��ư Ű ������ �г� 1�� ȣ��
      @Override
      public void actionPerformed(ActionEvent e) {
         if(t1.getText().equals("")==true||t2.getText().equals("")==true||(ck1.isSelected()==false&&ck2.isSelected()==false&&ck3.isSelected()==false&&ck4.isSelected()==false&&ck5.isSelected()==false&&ck6.isSelected()==false))
          {
           JOptionPane.showMessageDialog(null,"���� ��� �Էµ��� �ʾҰų� üũ���� �ʾҽ��ϴ�!");
          }
         else
         {
         String material = "";
         Connection conn = DBconnect.getConnection();
         Statement stmt = null;
         int rs = 0;

         if (ck1.isSelected()) {
            material = "no2";
         }
         if (ck2.isSelected()) {
            material = "o3";
         }
         if (ck3.isSelected()) {
            material = "co2";
         }
         if (ck4.isSelected()) {
            material = "so2";
         }
         if (ck5.isSelected()) {
            material = "microdust";
         }
         if (ck6.isSelected()) {
            material = "ultrafinemicrodust";
         }

         try {
            stmt = conn.createStatement();

            String sql = "update " + DBconnect.table + " set " + material + "=0" + " where date='2018"
                  + t1.getText() + t2.getText() + "' and local='" + cb.getSelectedItem().toString() + "'";

            System.out.println(sql);
            rs = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"���� �Ϸ�!");
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         }
      }
  }
//��ȸ�ϱ� ��ư�� Ŭ���ϸ� �ش� ���� ��ȸ��
  class ApplyActionListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e) {
        if(t1.getText().equals("")==true||t2.getText().equals("")==true||(ck1.isSelected()==false&&ck2.isSelected()==false&&ck3.isSelected()==false&&ck4.isSelected()==false&&ck5.isSelected()==false&&ck6.isSelected()==false))
      {
         JOptionPane.showMessageDialog(null,"���� ��� �Էµ��� �ʾҰų� üũ���� �ʾҽ��ϴ�!");
      }
        else
        {
         String material = "";
         String data = "";
         Connection conn = DBconnect.getConnection();
         Statement stmt = null;
         ResultSet rs = null;

         if (ck1.isSelected()) {
            material = "no2";
         }
         if (ck2.isSelected()) {
            material = "o3";
         }
         if (ck3.isSelected()) {
            material = "co2";
         }
         if (ck4.isSelected()) {
            material = "so2";
         }
         if (ck5.isSelected()) {
            material = "microdust";
         }
         if (ck6.isSelected()) {
            material = "ultrafinemicrodust";
         }

         data = material + "=";

         try {
            stmt = conn.createStatement();

            String sql = "select " + material + " from " + DBconnect.table + " where " + "date='" + "2018"
                  + t1.getText() + t2.getText() + "' and local='" + cb.getSelectedItem().toString() + "'";

            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
               data += rs.getString(material);
               if (data.equals("")) {
                  data = "0";
               }
            }
            System.out.println(data);
         } catch (SQLException e1) {
            e1.printStackTrace();
         } finally {
            DBconnect.close(stmt);
            textArea.setText(data);
         }
      }
     }
  }
}

// �߰��ϱ� �г� Ŭ����
@SuppressWarnings("serial")
class Create extends JPanel{
   public String[] region = { "������", "�������", "������", "�����Ϸ�", "���ϱ�", "������", "���״��", "���Ǳ�", "���ǻ�", "������", "���α�", "�õ�", "��õ��",
         "����", "�����", "������", "������", "���빮��", "���۱�", "������", "���빮��", "���۱�", "���۴��", "������", "���ѻ�", "���빮��", "���ʱ�",
         "������", "���ϱ�", "����", "���ı�", "������", "���̷�", "��õ��", "��������", "��������", "��걸", "����", "������", "����", "���α�", "�߱�",
         "�߶���", "õȣ���", "û��õ��", "�Ѱ����", "����", "ȫ����", "ȭ����" };
   public JLabel ck1 = new JLabel("�̻�ȭ����");
   public JLabel ck2 = new JLabel("����");
   public JLabel ck3 = new JLabel("�̻�ȭź��");
   public JLabel ck4 = new JLabel("��Ȳ�갡��");
   public JLabel ck5 = new JLabel("�̼�����");
   public JLabel ck6 = new JLabel("�ʹ̼�����");
   public JTextField No2 = new JTextField(10); // ������ �Է� ����
   public JTextField O3 = new JTextField(10); // ������ �Է� ����
   public JTextField Co2 = new JTextField(10); // ������ �Է� ����
   public JTextField So2 = new JTextField(10); // ������ �Է� ����
   public JTextField MD = new JTextField(10); // ������ �Է� ����
   public JTextField UMD = new JTextField(10); // ������ �Է� ����
   public JTextField t = new JTextField(3); // �� �Է�
   public JTextField t1 = new JTextField(2); // �� �Է�
   public JTextField t2 = new JTextField(2); // �� �Է�
   public JTextField t3 = new JTextField(14); // ���� �Է�
   public JComboBox<String> cb = new JComboBox<>(region);
   public JTextArea textArea = new JTextArea(1, 10);
   public JButton create = new JButton("�߰��ϱ�");
   public JButton btn = new JButton("�ڷΰ���");
   public JPanelTest win;
   
   public Create(JPanelTest win) {
      setLayout(null);
      this.win = win;
      setLayout(new BorderLayout(10,10));
      setBackground(Color.WHITE);
       showForm();
       // �޴��� ����
        MenuBarView menuBar = new MenuBarView();
        add(menuBar.showMenuBar(), BorderLayout.NORTH);
       btn.addActionListener(new MyActionListener());
       create.addActionListener(new createActionListener());
   }
   
   void showForm() {
      
       JPanel p1 = new JPanel(new BorderLayout()); // ������¥���� + ��������
      JPanel p2 = new JPanel(new BorderLayout()); // �������� + ��¥����
      JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // ��������
      JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // ��¥����
      JPanel p4_1 = new JPanel(new FlowLayout());
      JPanel p5 = new JPanel(new BorderLayout()); // ��������
      
      
      JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      
      JPanel Eastpanel = new JPanel(new GridLayout(3,1));
      JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      
      JPanel Northpanel = new JPanel(new GridLayout(1,0));
      
      p1.setBackground(Color.WHITE);
      p2.setBackground(Color.WHITE);
      p3.setBackground(Color.WHITE);
      p4.setBackground(Color.WHITE);
      p4_1.setBackground(Color.WHITE);
      Westpanel.setBackground(Color.WHITE);
      Eastpanel.setBackground(Color.WHITE);
      E_p1.setBackground(Color.WHITE);
      E_p2.setBackground(Color.WHITE);
      E_p3.setBackground(Color.WHITE);
      Northpanel.setBackground(Color.WHITE);
      
      
      Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
      JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
      Title.setBackground(Color.WHITE);
      JLabel title = new JLabel("Add Data");
      title.setFont(new Font("���ü", Font.PLAIN, 30));
      Title.add(title);
      Northpanel.add(Title);
      add(Northpanel, BorderLayout.CENTER);
      
      Eastpanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 150, 10));
      JLabel l1 = new JLabel("����� �Է��� �� �߰��ϱ� ��ư�� Ŭ���ϼ���.");
      E_p1.add(title);
      E_p2.add(l1);
      E_p3.add(btn);
      E_p3.add(create);
      Eastpanel.add(E_p1);
      Eastpanel.add(E_p2);
      Eastpanel.add(E_p3);
      add(Eastpanel, BorderLayout.CENTER);
      
      JLabel lbl1 = new JLabel("��¥�� �Է� �ϼ���:");
      JLabel lbl2 = new JLabel("������ ���� �ϼ���:");
      JLabel lbl3 = new JLabel("��");
      JLabel month = new JLabel("��");
      JLabel day = new JLabel("��");
      JLabel lbl4 = new JLabel("[    �ش� ������ ���� �Է��ϼ���.    ]");
      
      cb.setPreferredSize(new Dimension(200, 25));
      
      Box No2Box = Box.createVerticalBox();
      Box O3Box = Box.createVerticalBox();
      Box Co2Box = Box.createVerticalBox();
      Box So2Box = Box.createVerticalBox();
      Box MDBox = Box.createVerticalBox();
      Box UMDBox = Box.createVerticalBox();
      
      p1.setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0));
   
      Westpanel.add(p1);
      
      p1.add(p2, BorderLayout.NORTH);
      p1.add(p5, BorderLayout.CENTER);
   
      p2.add(p3, BorderLayout.NORTH);
      p2.add(p4, BorderLayout.CENTER);
      p3.add(lbl2);
      p3.add(t3);
      p4.add(lbl1);
      p4.add(p4_1);
      p4_1.add(t);
      p4_1.add(lbl3);
      p4_1.add(t1);
      p4_1.add(month);
      p4_1.add(t2);
      p4_1.add(day);
      
      JPanel p7 = new JPanel(new GridLayout(3,2,30,30)); // ���� �Է� �ڽ� ����
      JPanel p7_0 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // �������ö�
      JPanel p7_1 = new JPanel(new BorderLayout());
      JPanel p7_2 = new JPanel(new BorderLayout());
      JPanel p7_3 = new JPanel(new BorderLayout());
      JPanel p7_4 = new JPanel(new BorderLayout());
      JPanel p7_5 = new JPanel(new BorderLayout());
      JPanel p7_6 = new JPanel(new BorderLayout());
      
      p7.setBackground(Color.WHITE);
      p7_0.setBackground(Color.WHITE);
      p7_1.setBackground(Color.WHITE);
      p7_2.setBackground(Color.WHITE);
      p7_3.setBackground(Color.WHITE);
      p7_4.setBackground(Color.WHITE);
      p7_5.setBackground(Color.WHITE);
      p7_6.setBackground(Color.WHITE);
      
      JPanel No2Panel = new JPanel(new BorderLayout());
      JPanel O3Panel = new JPanel(new BorderLayout());
      JPanel Co2Panel = new JPanel(new BorderLayout());
      JPanel So2Panel = new JPanel(new BorderLayout());
      JPanel MDPanel = new JPanel(new BorderLayout());
      JPanel UMDPanel = new JPanel(new BorderLayout());
      
      
      p5.add(p7_0, BorderLayout.NORTH);
      p5.add(p7, BorderLayout.CENTER);
      
      No2Panel.setBorder(new TitledBorder(new EtchedBorder(), " No2 "));
      O3Panel.setBorder(new TitledBorder(new EtchedBorder(), " O3 "));
      Co2Panel.setBorder(new TitledBorder(new EtchedBorder(), " Co2 "));
      So2Panel.setBorder(new TitledBorder(new EtchedBorder(), " So2 "));
      MDPanel.setBorder(new TitledBorder(new EtchedBorder(), " MicroDust "));
      UMDPanel.setBorder(new TitledBorder(new EtchedBorder(), " UltrafineMicroDust "));
      
      
      p7_0.add(lbl4); // ���� ���� �Է��ϼ��� (��)
      p7.add(p7_1);
      p7.add(p7_2);
      p7.add(p7_3);
      p7.add(p7_4);
      p7.add(p7_5);
      p7.add(p7_6);
      
      // 1:no2, 2:O3, 3:Co2, 4:So2, 5:MD, 6:UMD
      p7_1.add(No2Panel, BorderLayout.CENTER);
      p7_2.add(O3Panel, BorderLayout.CENTER);
      p7_3.add(Co2Panel, BorderLayout.CENTER);
      p7_4.add(So2Panel, BorderLayout.CENTER);
      p7_5.add(MDPanel, BorderLayout.CENTER);
      p7_6.add(UMDPanel, BorderLayout.CENTER);
      
      
      No2Panel.add(No2Box, BorderLayout.CENTER);
      No2Box.add(Box.createVerticalStrut(5));
      No2Box.add(ck1);
      No2Box.add(No2);
      
      O3Panel.add(O3Box, BorderLayout.CENTER);
      O3Box.add(Box.createVerticalStrut(5));
      O3Box.add(ck2);
      O3Box.add(O3);
      
      Co2Panel.add(Co2Box,BorderLayout.CENTER);
      Co2Box.add(Box.createVerticalStrut(5));
      Co2Box.add(ck3);
      Co2Box.add(Co2);
      
      So2Panel.add(So2Box, BorderLayout.CENTER);
      So2Box.add(Box.createVerticalStrut(5));
      So2Box.add(ck4);  // ��Ȳ��
      So2Box.add(So2);
      
      MDPanel.add(MDBox, BorderLayout.CENTER);
      MDBox.add(Box.createVerticalStrut(5));
      MDBox.add(ck5);  // �̼�
      MDBox.add(MD);
      
      UMDPanel.add(UMDBox, BorderLayout.CENTER);
      UMDBox.add(Box.createVerticalStrut(5));
      UMDBox.add(ck6);  // �ʹ̼�
      UMDBox.add(UMD);
   
      add(Westpanel, BorderLayout.WEST);   
   }
    
   
   class MyActionListener implements ActionListener { // ��ư Ű ������ �г� 1�� ȣ��
         @Override
         public void actionPerformed(ActionEvent e) {
             win.change("panel01"); // �ڷΰ��� ��ư�� ������ ���ư���.
         }
   }
   
   // ������
   class createActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if(t1.getText().equals("")==true||t2.getText().equals("")==true||t.getText().equals("")==true||t3.getText().equals("")==true||No2.getText().equals("")==true||O3.getText().equals("")==true||
               Co2.getText().equals("")==true||So2.getText().equals("")==true||MD.getText().equals("")==true||UMD.getText().equals("")==true)
         {
            JOptionPane.showMessageDialog(null,"���� ��� �Է����ּ���!");
         }
         else
         {
            Connection conn = DBconnect.getConnection();
            Statement stmt = null;
            int rs1 = 0;
            int rs2=0;
            try{
               stmt = conn.createStatement();
               System.out.println(No2.getText());
               String sql1="use "+DBconnect.table;
               String sql2 = "insert into " + DBconnect.table +"(date,local,no2,o3,co2,so2,microdust,ultrafinemicrodust)"+"values("+"'"+t.getText()+t1.getText()+t2.getText()+"', '"+t3.getText()+"', '"+No2.getText()+"', '"+
                     O3.getText()+"', '"+Co2.getText()+"', '"+So2.getText()+"', '"+MD.getText()+"', '"+UMD.getText()+"')";   
               
               System.out.println(sql1);
               System.out.println(sql2);
               rs1 = stmt.executeUpdate(sql1);
               rs2 = stmt.executeUpdate(sql2);
               JOptionPane.showMessageDialog(null,"�߰� �Ϸ�!");
            }catch (SQLException e1) {
               e1.printStackTrace();
            }
         }
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

public class ModifyDB extends JFrame{
   // ������
   public ModifyDB() {
      JPanelTest win = new JPanelTest();
      
        win.setTitle("����");
        // �޴��� �߰�
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