package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DateView extends JFrame {
   String[] region = { "강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구", "구로구", "궁동", "금천구",
         "남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구",
         "성동구", "성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구",
         "중랑구", "천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };
   ImagePanel panel=new ImagePanel();
   ImagePanel mp;
   JComboBox<String> LocalChooseC = new JComboBox<>(region);
   JTextField MonthT = new JTextField(2);
   JTextField DateT = new JTextField(2);
   double[] data1 = new double[4];
   double[] data2 = new double[2];
   String[] ppm = new String[4];
   String[] ug = new String[2];
   ClearPanel p6 = new ClearPanel(new GridLayout(1, 2, 0, 1000));
   //ClearPanel p5 = new ClearPanel(new GridLayout(1, 1));
   ClearPanel p5 = new ClearPanel(new BorderLayout());
   double concentration;

   DateView(ImagePanel mp) {
      setTitle("고갱이");
      this.mp=mp;
      panel.setLayout(new BorderLayout());
      ppm[0] = "이산화질소";
      ppm[1] = "오존";
      ppm[2] = "이산화탄소";
      ppm[3] = "아황산가스";
      ug[0] = "미세먼지";
      ug[1] = "초미세먼지";

      // 메뉴바 추가
      MenuBarView menuBar = new MenuBarView(mp,panel);
      setJMenuBar(menuBar.showMenuBar());
      add(panel);
      
      ClearPanel p = new ClearPanel(new BorderLayout());
      ClearPanel p1 = new ClearPanel(new FlowLayout());
      ClearPanel p2 = new ClearPanel(new FlowLayout());
      ClearPanel p3 = new ClearPanel(new GridLayout(3, 1));
      ClearPanel p4 = new ClearPanel();

      JLabel label = new JLabel("날짜별 비교");
      JLabel LocalChooseL = new JLabel("지역 선택");
      JLabel DateChooseL = new JLabel("날짜 선택 ");
      JLabel YearL = new JLabel("2018년");
      JLabel MonthL = new JLabel(" 월");
      JLabel DateL = new JLabel(" 일");
      JLabel Today = new JLabel("오늘 고갱이의 기분");

      JButton ApplyB = new JButton("적용");
      JLabel star = new JLabel("* 이산화탄소는 본 값의 1/10값입니다.");

      LocalChooseC.setPreferredSize(new Dimension(150, 25));
      label.setFont(new Font("맑은고딕", Font.PLAIN, 30));
      p2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
      p.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
      p4.setBorder(BorderFactory.createEmptyBorder(0, 730, 0, 0));
      p5.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));

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
      p.add(p3, BorderLayout.WEST);
      // p5.add(Today);
      p.add(p5, BorderLayout.CENTER);
      p6.add(star);

      panel.add(p, BorderLayout.NORTH);
      panel.add(p6, BorderLayout.CENTER);
      panel.add(p4, BorderLayout.SOUTH);
      setSize(800, 500);
      setVisible(true);

      ApplyB.addActionListener(new DrawActionListener());
   }

   public void showCenter() {
      BarGraph graph1 = new BarGraph(data1, ppm, 50, 20, 1000);
      BarGraph graph2 = new BarGraph(data2, ug, 50, 20, 1);
      p6.add(graph1);
      p6.add(graph2);
      JLabel img;
      if (concentration < 1.5) {
         ImageIcon icon = new ImageIcon("./image/gogang0.png");
         Image im = icon.getImage();
         Image im2 = im.getScaledInstance(280, 100, Image.SCALE_DEFAULT);
         ImageIcon icon2 = new ImageIcon(im2);
         img = new JLabel(icon2);
         img.setIcon(icon2);
         
      } else if (concentration < 2) {
         ImageIcon icon = new ImageIcon("./image/gogang1.png");
         Image im = icon.getImage();
         Image im2 = im.getScaledInstance(280, 100, Image.SCALE_DEFAULT);
         ImageIcon icon2 = new ImageIcon(im2);
         img = new JLabel(icon2);
         img.setIcon(icon2);
         //p5.add(img);
      } else if (concentration < 3) {
         ImageIcon icon = new ImageIcon("./image/gogang2.png");
         Image im = icon.getImage();
         Image im2 = im.getScaledInstance(280, 100, Image.SCALE_DEFAULT);
         ImageIcon icon2 = new ImageIcon(im2);
         img = new JLabel(icon2);
         img.setIcon(icon2);
         //p5.add(img);
      } else {
         ImageIcon icon = new ImageIcon("./image/gogang3.png");
         Image im = icon.getImage();
         Image im2 = im.getScaledInstance(280, 100, Image.SCALE_DEFAULT);
         ImageIcon icon2 = new ImageIcon(im2);
         img = new JLabel(icon2);
         img.setIcon(icon2);
         //p5.add(img);
      }
      
      p5.add(img,BorderLayout.CENTER);
      panel.add(p6, BorderLayout.CENTER);
      p6.revalidate();
      p6.repaint();
   }

   public double Concentration() {
      int No2, O3, Co2, So2, mic, umic;
      double avg;

      if (data1[0] <= 0.02) {
         No2 = 3;
      } else if (data1[0] <= 0.05) {
         No2 = 2;
      } else if (data1[0] <= 0.15) {
         No2 = 1;
      } else {
         No2 = 0;
      }

      if (data1[1] <= 0.03) {
         O3 = 3;
      } else if (data1[1] <= 0.09) {
         O3 = 2;
      } else if (data1[1] <= 0.15) {
         O3 = 1;
      } else {
         O3 = 0;
      }

      if (data1[2] <= 0.2) {
         Co2 = 3;
      } else if (data1[2] <= 0.9) {
         Co2 = 2;
      } else if (data1[2] <= 1.5) {
         Co2 = 1;
      } else {
         Co2 = 0;
      }

      if (data1[3] <= 0.03) {
         So2 = 3;
      } else if (data1[3] <= 0.06) {
         So2 = 2;
      } else if (data1[3] <= 0.2) {
         So2 = 1;
      } else {
         So2 = 0;
      }

      if (data2[0] <= 30) {
         mic = 3;
      } else if (data2[0] <= 80) {
         mic = 2;
      } else if (data1[0] <= 150) {
         mic = 1;
      } else {
         mic = 0;
      }

      if (data2[1] <= 10) {
         umic = 3;
      } else if (data2[1] <= 30) {
         umic = 2;
      } else if (data2[1] <= 70) {
         umic = 1;
      } else {
         umic = 0;
      }

      avg = (No2 + (O3*0.3) + Co2 + (So2*0.3)+ (mic*1.5) + (umic*2)) / 6;

      return avg;
   }

   class DrawActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         Connection conn = DBconnect.getConnection();
         Statement stmt1 = null;
         Statement stmt2 = null;
         Statement stmt3 = null;
         Statement stmt4 = null;
         Statement stmt5 = null;
         Statement stmt6 = null;
         Statement stmt7 = null;
         ResultSet rs1 = null;
         ResultSet rs2 = null;
         ResultSet rs3 = null;
         ResultSet rs4 = null;
         ResultSet rs5 = null;
         ResultSet rs6 = null;
         String local = LocalChooseC.getSelectedItem().toString();
         String date = "2018" + MonthT.getText() + DateT.getText();
         String no2 = "";
         String o3 = "";
         String co2 = "";
         String so2 = "";
         String microdust = "";
         String ultrafinemicrodust = "";

         try {
            stmt1 = conn.createStatement();
            stmt2 = conn.createStatement();
            stmt3 = conn.createStatement();
            stmt4 = conn.createStatement();
            stmt5 = conn.createStatement();
            stmt6 = conn.createStatement();
            stmt7 = conn.createStatement();

            String sql1 = "select no2 from " + DBconnect.table + " where " + "date='" + date + "' and local='" + local + "'";
            String sql2 = "select o3 from " + DBconnect.table + " where " + "date='" + date + "' and local='" + local + "'";
            String sql3 = "select co2 from " + DBconnect.table + " where " + "date='" + date + "' and local='" + local + "'";
            String sql4 = "select so2 from " + DBconnect.table + " where " + "date='" + date + "' and local='" + local + "'";
            String sql5 = "select microdust from " + DBconnect.table + " where " + "date='" + date + "' and local='" + local + "'";
            String sql6 = "select ultrafinemicrodust from " + DBconnect.table + " where " + "date='" + date + "' and local='" + local
                  + "'";
            String sql7="use "+DBconnect.table;

            stmt7.executeQuery(sql7);
            rs1 = stmt1.executeQuery(sql1);
            rs2 = stmt2.executeQuery(sql2);
            rs3 = stmt3.executeQuery(sql3);
            rs4 = stmt4.executeQuery(sql4);
            rs5 = stmt5.executeQuery(sql5);
            rs6 = stmt6.executeQuery(sql6);
            System.out.println(sql1);
            while (rs1.next()) {
               no2 = rs1.getString("no2");
               if (no2.equals("")) {
                  no2 = "0";
               }
            }

            while (rs2.next()) {
               o3 = rs2.getString("o3");
               if (o3.equals("")) {
                  o3 = "0";
               }
            }

            while (rs3.next()) {
               co2 = rs3.getString("co2");
               if (co2.equals("")) {
                  co2 = "0";
               }
            }

            while (rs4.next()) {
               so2 = rs4.getString("so2");
               if (so2.equals("")) {
                  so2 = "0";
               }
            }

            while (rs5.next()) {
               microdust = rs5.getString("microdust");
               if (microdust.equals("")) {
                  microdust = "0";
               }
            }

            while (rs6.next()) {
               ultrafinemicrodust = rs6.getString("ultrafinemicrodust");
               if (ultrafinemicrodust.equals("")) {
                  ultrafinemicrodust = "0";
               }
            }
         } catch (SQLException e1) {
            System.out.println(e1);
         } finally {
            DBconnect.close(stmt1);
            DBconnect.close(stmt2);
            DBconnect.close(stmt3);
            DBconnect.close(stmt4);
            DBconnect.close(stmt5);
            DBconnect.close(stmt6);
         }
         String[] str1 = new String[4];
         String[] str2 = new String[2];
         String st1 = no2 + "\n" + o3 + "\n" + co2 + "\n" + so2;
         String st2 = microdust + "\n" + ultrafinemicrodust;
         str1 = st1.split("\n");
         str2 = st2.split("\n");
         for (int i = 0; i < 4; i++) {
            System.out.println(str1[i]);
         }
         for (int i = 0; i < 2; i++) {
            System.out.println(str2[i]);
         }
         for (int i = 0; i < 4; i++) {
            data1[i] = Double.parseDouble(str1[i]);
         }
         for (int i = 0; i < 2; i++) {
            data2[i] = Double.parseDouble(str2[i]);
         }
         data1[2] = data1[2] * (0.1);
         concentration = Concentration();
         System.out.println(concentration);
         p5.removeAll();
         p6.removeAll();
         showCenter();
      }
   }
}