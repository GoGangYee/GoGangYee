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
		
		String[] region = {"강남구","강남대로","강동구","강변북로","강북구","강서구","공항대로","관악구","관악산","광진구","구로구","궁동","금천구","남산","노원구","도봉구","도산대로","동대문구","동작구","도산대로","동대문구","동작구","동작대로","마포구","북한산","서대문구","서초구","성동구","성북구","세곡","송파구","시흥대로","신촌로","양천구","영등포구","영등포로","용산구","은평구","정릉로","종로","종로구","중구","중랑구","천호대로","청계천로","한강대로","행주","홍릉로","화랑로"};
		JPanel p=new JPanel(new BorderLayout());
		JPanel p1=new JPanel(new FlowLayout());
		JPanel p2=new JPanel(new FlowLayout());
		JPanel p3=new JPanel(new GridLayout(3,1));
		JPanel p4=new JPanel();
		JPanel p5=new JPanel(new GridLayout(2,1));
		JPanel p6=new JPanel(new GridLayout(1,2));
		
		JLabel label=new JLabel("날짜별 비교");
		JLabel LocalChooseL=new JLabel("지역 선택");
		JLabel DateChooseL=new JLabel("날짜 선택 ");
		JLabel YearL=new JLabel("2018년");
		JLabel MonthL=new JLabel(" 월");
		JLabel DateL=new JLabel(" 일");
		JLabel Today=new JLabel("오늘 고갱이의 기분");
		JComboBox<String> LocalChooseC=new JComboBox<>(region);
		JTextField MonthT=new JTextField(2);
		JTextField DateT=new JTextField(2);
		JButton ApplyB=new JButton("적용");
		JButton HelpB=new JButton("?");
		
		LocalChooseC.setPreferredSize(new Dimension(150,25));
		label.setFont(new Font("맑은고딕",Font.PLAIN,30));
		HelpB.setFont(new Font("맑은고딕",Font.BOLD,13));
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
		//p5.add(고갱이이미지) 고갱이 추가
		p.add(p5,BorderLayout.CENTER);
		//p6.add(그래프)
		//p6.add(그래프)
		p4.add(HelpB);
		
		
		getContentPane().add(p,"North");
		//getContentPane().add(p6,"Center");
		getContentPane().add(p4,"South");
		
		HelpB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이산화질소\r\n" + 
						" * 코와 인후자극\r\n" + 
						" * 호흡기에 나쁜 영향\r\n" + 
						"\r\n" + 
						"오존\r\n" + 
						" * 눈 자극, 농작물 피해\r\n" + 
						"\r\n" + 
						"일산화탄소\r\n" + 
						" * 산소공급 저조, 두통, 현기증 유발\r\n" + 
						"\r\n" + 
						"아황산가스\r\n" + 
						" * 인체호흡기 질환\r\n" + 
						" * 식물의 성장 방해\r\n" + 
						"\r\n" + 
						"미세먼지\r\n" + 
						" * 아황산가스와 결합하여 호흡기질환 유발\r\n" + 
						"\r\n" + 
						"초미세먼지\r\n" + 
						" * 아황산가스와 결합하여 호흡기질환 유발\r\n" + 
						"\r\n" + 
						"출처 - 수원시청","물질별 설명",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		setSize(800,500);
		setVisible(true);
	}
}