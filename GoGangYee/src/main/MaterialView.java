package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MaterialView extends JFrame {
	String[] region = { " 강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구", "구로구", "궁동", "금천구",
			"남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구",
			"성동구", "성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구",
			"중랑구", "천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };
	ImagePanel imgPanel=new ImagePanel();
	ImagePanel mp;	//메인패널
	
	JComboBox<String> localSelect = new JComboBox<>(region);
	JButton apply = new JButton("적용");
	JTextField monthTF1 = new JTextField(2);
	JTextField monthTF2 = new JTextField(2);
	JTextField dayTF1 = new JTextField(2);
	JTextField dayTF2 = new JTextField(2);
	JRadioButton ck1 = new JRadioButton("이산화질소");
	JRadioButton ck2 = new JRadioButton("오존");
	JRadioButton ck3 = new JRadioButton("이산화탄소");
	JRadioButton ck4 = new JRadioButton("아황산가스");
	JRadioButton ck5 = new JRadioButton("미세먼지");
	JRadioButton ck6 = new JRadioButton("초미세먼지");
	double[] data1 = new double[365];
	int k = 0;
	String material = "";
	ClearPanel p1 = new ClearPanel();
	
	int startDate;	//시작 날짜, 끝 날짜
	int endDate;

	public MaterialView(ImagePanel mp) {
		setTitle("고갱이");
		this.mp=mp;
		add(imgPanel);
		imgPanel.setLayout(new BorderLayout(10,10));
		// 메뉴바 추가
		MenuBarView menuBar = new MenuBarView(mp, imgPanel);
		setJMenuBar(menuBar.showMenuBar());

		//setLayout(new BorderLayout(10, 10));
		showNorth();
		// showCenter();
		showSouth();

		setSize(800, 500);
		setVisible(true);
	}

	public void showNorth() {
		ClearPanel p1 = new ClearPanel(new BorderLayout()); // 지역, 날짜선택 영역
		ClearPanel p1_0 = new ClearPanel(new FlowLayout(FlowLayout.LEFT));
		ClearPanel p1_1 = new ClearPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		ClearPanel p1_4 = new ClearPanel(new BorderLayout());
		ClearPanel p1_2 = new ClearPanel(new FlowLayout(FlowLayout.LEFT)); // From date Choose
		ClearPanel p1_3 = new ClearPanel(new FlowLayout(FlowLayout.LEFT)); // to date choose
		ClearPanel p1_5 = new ClearPanel(new BorderLayout());
		ClearPanel p1_6 = new ClearPanel(new FlowLayout(FlowLayout.LEFT)); // From date Choose
		ClearPanel p1_7 = new ClearPanel(new BorderLayout());
		ClearPanel p2 = new ClearPanel(new BorderLayout()); // 물질선택 칸
		ClearPanel p2_0 = new ClearPanel(new FlowLayout(FlowLayout.CENTER));
		ClearPanel p2_1 = new ClearPanel(new BorderLayout()); // 물질 선택 왼쪽
		ClearPanel p2_2 = new ClearPanel(new BorderLayout()); // 물질 선택 오른쪽
		ClearPanel p2_1_1 = new ClearPanel(new BorderLayout());
		ClearPanel p2_2_1 = new ClearPanel(new BorderLayout());
		ClearPanel p2_3 = new ClearPanel(new GridLayout(1, 2));
		ClearPanel panel = new ClearPanel(new GridLayout(1, 2)); // 전체패널

		JLabel txt1 = new JLabel("물질별 비교");
		JLabel txt2 = new JLabel("지역 선택");
		JLabel txt3 = new JLabel("날짜 선택");
		JLabel year = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel year1 = new JLabel("2018년");
		JLabel month1 = new JLabel("월");
		JLabel day1 = new JLabel("일");
		JLabel fromTo = new JLabel("~");
		JLabel materialChoice = new JLabel("물질 선택");
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
		ButtonGroup radioBtns = new ButtonGroup(); // 물질 중복 선택을 방지하기 위한 버튼그룹

		radioBtns.add(ck1);
		radioBtns.add(ck2);
		radioBtns.add(ck3);
		radioBtns.add(ck4);
		radioBtns.add(ck5);
		radioBtns.add(ck6);
//		ck1.setOpaque(false);
//		ck2.setOpaque(false);
//		ck3.setOpaque(false);
//		ck4.setOpaque(false);
//		ck5.setOpaque(false);
//		ck6.setOpaque(false);

		localSelect.setPreferredSize(new Dimension(200, 25));
		txt1.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		p2_1_1.setBorder(new TitledBorder(new EtchedBorder(), " ppm "));
		p2_2_1.setBorder(new TitledBorder(new EtchedBorder(), " μg "));
		p2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		p1.add(p1_0, BorderLayout.NORTH);
		p1.add(p1_4, BorderLayout.CENTER);
		p1_4.add(p1_1, BorderLayout.NORTH);
		p1_4.add(p1_7, BorderLayout.CENTER);
		p1_7.add(p1_3, BorderLayout.WEST);
		p1_7.add(p1_5, BorderLayout.CENTER);
		p1_5.add(p1_2, BorderLayout.NORTH);
		p1_5.add(p1_6, BorderLayout.CENTER);
		p1_0.add(txt1);
		p1_1.add(txt2);
		p1_1.add(localSelect);
		p1_3.add(txt3);
		p1_2.add(year);
		p1_2.add(monthTF1);
		p1_2.add(month);
		p1_2.add(dayTF1);
		p1_2.add(day);
		p1_6.add(fromTo);
		p1_6.add(year1);
		p1_6.add(monthTF2);
		p1_6.add(month1);
		p1_6.add(dayTF2);
		p1_6.add(day1);

		p2.add(p2_0, BorderLayout.NORTH);
		p2.add(p2_3, BorderLayout.CENTER);
		p2.add(apply, BorderLayout.SOUTH);
		p2_0.add(materialChoice);
		p2_1.add(p2_1_1, BorderLayout.CENTER);
		p2_2.add(p2_2_1, BorderLayout.CENTER);
		p2_1_1.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
		p2_2_1.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
		p2_3.add(p2_1);
		p2_3.add(p2_2);

		panel.add(p1); // 지역, 날짜선택 칸
		panel.add(p2); // 물질선택 칸

		imgPanel.add(panel, BorderLayout.NORTH);
	}

	public void showCenter() {
		if (material.equals("microdust") == true || material.equals("ultrafinemicrodust") == true) {
			System.out.println("ewew");
			LineGraph graph = new LineGraph(data1, 1, 100, k, startDate, endDate);
			graph.setPreferredSize(new Dimension(750, 170));
			p1.add(graph);
			imgPanel.add(p1, BorderLayout.CENTER);
			repaint();
		}
		if (material.equals("co2")) {
			LineGraph graph = new LineGraph(data1, 100, 100, k, startDate, endDate);
			graph.setPreferredSize(new Dimension(750, 170));
			p1.add(graph);
			imgPanel.add(p1, BorderLayout.CENTER);
		}
		if (material.equals("no2") == true || material.equals("o3") == true || material.equals("so2") == true) {
			System.out.println("ewel");
			LineGraph graph = new LineGraph(data1, 2000, 100, k, startDate, endDate);
			graph.setPreferredSize(new Dimension(750, 170));
			p1.add(graph);
			imgPanel.add(p1, BorderLayout.CENTER);
		}
		p1.revalidate();
		p1.repaint();
		k = 0;
		// graph.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
	}

	public void showSouth() {
		ClearPanel panel = new ClearPanel(new FlowLayout(FlowLayout.RIGHT));

		imgPanel.add(panel, BorderLayout.SOUTH);

		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = DBconnect.getConnection();
				Statement stmt = null;
				ResultSet rs = null;

				String value = "";

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
					// 연결
					stmt = conn.createStatement();

					String sql = "select " + material + " from " + DBconnect.table + " where date>='2018"
							+ monthTF1.getText() + dayTF1.getText() + "'" + " and date<='2018" + monthTF2.getText()
							+ dayTF2.getText() + "'" + " and local='" + localSelect.getSelectedItem().toString() + "'";

					System.out.println(sql);
					rs = stmt.executeQuery(sql);
					System.out.println(rs);
					while (rs.next()) {
						String v = "";
						v = rs.getString(material) + "\n";
						if (rs.getString(material).equals("")) {
							v = "0";
						}
						value += v;
						v = "";
					}
				} catch (SQLException e1) {
					System.out.println(e1);
				} finally {
					DBconnect.close(stmt);
				}
				String[] data = value.split("\n");

				for (int i = 0; i < data.length; i++) {
					data1[i] = Double.parseDouble(data[i]);
					k++;
				}
				for (int i = 0; i < data.length; i++) {
					System.out.println(data1[i]);
				}
				p1.removeAll();
				startDate=Integer.parseInt(monthTF1.getText()+dayTF1.getText());
				endDate=Integer.parseInt(monthTF2.getText()+dayTF2.getText());//라벨  설정
				showCenter();
			}
		});
	}
}