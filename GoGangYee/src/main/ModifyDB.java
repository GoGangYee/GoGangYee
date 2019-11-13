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
			setTitle("수정 및 삭제");
			
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
			
			JLabel lbl1 = new JLabel("수정 및 삭제");
			lbl1.setFont(new Font("맑은고딕", Font.PLAIN, 30));
			p1.add(lbl1);
			panel.add(p1);
			
			add(panel, BorderLayout.NORTH);
		}
		void showWest() {
			String[] region = {"강서구", "서초구"};
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			
			JPanel p4 = new JPanel(new GridLayout(0,2));
			JPanel p5 = new JPanel(); // 물질 선택 라벨
			JPanel p6 = new JPanel(); // 단위 선택 라디오 버튼
			JPanel p7 = new JPanel(new GridLayout(4,0)); // 체크박스 1
			JPanel p8 = new JPanel(new GridLayout(2,0)); // 체크박스 2
			
			//JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
			JPanel panel = new JPanel(new GridLayout(4,0));
			
			JLabel lbl2 = new JLabel("지역 선택");
			JLabel lbl3 = new JLabel("날짜 입력 : 2018년 ");
			JLabel month = new JLabel("월");
			JLabel day = new JLabel("일");
			JLabel lbl4 = new JLabel("물질 선택");
			
			JComboBox<String> cb = new JComboBox<>(region);
			cb.setPreferredSize(new Dimension(150,20));
			
			JTextField t1 = new JTextField(2); // 월 입력
			JTextField t2 = new JTextField(2); // 일 입력
			
			JRadioButton rdo1 = new JRadioButton("ppm");
			JRadioButton rdo2 = new JRadioButton("μg");
			JCheckBox ck1 = new JCheckBox("이산화질수");
			JCheckBox ck2 = new JCheckBox("일산화산소");
			JCheckBox ck3 = new JCheckBox("아황산가스");
			JCheckBox ck4 = new JCheckBox("오존");
			JCheckBox ck5 = new JCheckBox("미세먼지");
			JCheckBox ck6 = new JCheckBox("초미세먼지");
			
			p2.add(lbl2);	// 지역 선택
			p2.add(cb);		// 콤보 박스
			
			p3.add(lbl3);	// 날짜 입력 : 2018년 라벨
			p3.add(t1);		// 월 텍스트 필드
			p3.add(month);
			p3.add(t2);		// 일 텍스트 필드
			p3.add(day);
			
			p5.add(lbl4);	// 물질 선택
			
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
			
			JLabel l1 = new JLabel("수정할 데이터를 입력하세요.");
			JTextField t1 = new JTextField(10); // 수정할 데이터 입력 영역
			JButton b1 = new JButton("수정");
			
			p1.add(l1);
			p1.add(t1);
			p1.add(b1);
			
			JLabel l2 = new JLabel("삭제하려면 클릭하세요.");
			JButton b2 = new JButton("삭제");
			
			p2.add(l2);
			p2.add(b2);
			
			p1.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
			p2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
			
			panel.add(p1);
			panel.add(p2);
			
			add(panel, BorderLayout.CENTER);
		}
	}
	
	
	public static void main(String[] args) {
		new modifyDB();

	}

}
