package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LocalView extends JFrame{
	 LocalView(){
		 setTitle("고갱이 - 지역별 비교");	
		 
		 setLayout(new BorderLayout());
		 
		 JPanel content=new JPanel(new GridLayout(1,2));
		 JPanel left=new JPanel(new BorderLayout());
		 //left.setLayout(new GridLayout(2,1));
		 JLabel name=new JLabel("지  역  별     비  교");
		 name.setFont(new Font("맑은고딕",Font.BOLD,20));
		 name.setBorder(BorderFactory.createEmptyBorder(0,90,0,0));
		 JPanel graph=new JPanel();
		 graph.setBackground(Color.BLACK);
		 graph.setPreferredSize(new Dimension(400,300));

		 left.add(name,BorderLayout.NORTH);
		 left.add(graph);
		 
		 left.setBorder(BorderFactory.createEmptyBorder(10,10,20,20));
		 content.add(left);
		 
		 
		 //JPanel right=new JPanel(new GridLayout(4,1,0,20));	//물질 선택, 지역 선택, 날짜 넣을 부분
		 JPanel right=new JPanel(new GridLayout(3,1,0,20));
		 right.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		 
		 JPanel materials=new JPanel(new GridLayout(2,1));	//gas(ppm), dust(㎍)넣을 부분
		 
		 JPanel radioBtns=new JPanel(new GridLayout(1,2,50,0));
		 ButtonGroup rdo=new ButtonGroup();
		 JRadioButton ppm=new JRadioButton("ppm");
		 ppm.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JRadioButton dusts=new JRadioButton("㎍");
		 dusts.setFont(new Font("맑은고딕",Font.BOLD,15));
		 rdo.add(ppm);
		 rdo.add(dusts);
		 
		 radioBtns.add(ppm);
		 radioBtns.add(dusts);
		 radioBtns.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		 materials.add(radioBtns);
		 
		 JPanel chkBoxes=new JPanel(new GridLayout(1,2,0,10));	//가스와 미세먼지 각 체크박스를 넣을 공간입니다.
		 //chkBoxes.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		 JPanel gas=new JPanel();
		 gas.setLayout(new GridLayout(4,1));
		 JCheckBox no2=new JCheckBox("이산화질소");
		 no2.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 JCheckBox ozone=new JCheckBox("오존");
		 ozone.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 JCheckBox co2=new JCheckBox("이산화탄소");
		 co2.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 JCheckBox so2=new JCheckBox("아황산가스");
		 so2.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 
		 gas.add(no2);
		 gas.add(ozone);
		 gas.add(co2);
		 gas.add(so2);
		 
		 chkBoxes.add(gas);
		
		 
		 JPanel dust=new JPanel();
		 dust.setLayout(new GridLayout(2,1));
		 JCheckBox finedust=new JCheckBox("미세먼지");
		 finedust.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 JCheckBox ultrafinedust=new JCheckBox("초미세먼지");
		 ultrafinedust.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 
		 dust.add(finedust);
		 dust.add(ultrafinedust);
		
		 chkBoxes.add(dust);
		 
		 materials.add(chkBoxes);
		 right.add(materials);
		 
		 
		 JPanel regions=new JPanel(new GridLayout(4,2,0,5));
		 //regions.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		 JLabel r1=new JLabel("지역 1");
		 r1.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JTextField rt1=new JTextField();
		 JLabel r2=new JLabel("지역 2");
		 r2.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JTextField rt2=new JTextField();
		 JLabel r3=new JLabel("지역 3");
		 r3.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JTextField rt3=new JTextField();
		 JLabel r4=new JLabel("지역 4");
		 r4.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JTextField rt4=new JTextField();
		 
		 regions.add(r1);
		 regions.add(rt1);
		 regions.add(r2);
		 regions.add(rt2);
		 regions.add(r3);
		 regions.add(rt3);
		 regions.add(r4);
		 regions.add(rt4);
		 
		 right.add(regions);
		 
		 JPanel date=new JPanel(new FlowLayout());
		 JLabel d=new JLabel("날짜    ");
		 d.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JLabel year=new JLabel("2018년");
		 year.setFont(new Font("맑은고딕",Font.PLAIN,15));
		 JTextField month=new JTextField(5);
		 JLabel monthLabel=new JLabel("월");
		 monthLabel.setFont(new Font("맑은고딕",Font.BOLD,15));
		 JTextField day=new JTextField(5);
		 JLabel dayLabel=new JLabel("일");
		 dayLabel.setFont(new Font("맑은고딕",Font.BOLD,15));

		 //date.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		 date.add(d);
		 date.add(year);
		 date.add(month);
		 date.add(monthLabel);
		 date.add(day);
		 date.add(dayLabel);
		 
		 right.add(date);
		 content.add(right);
		 
		 add(content,BorderLayout.CENTER);
		 
		 //JPanel btns=new JPanel(new GridLayout(1,2,5,0));
		 JPanel btns=new JPanel(new FlowLayout(FlowLayout.LEFT,100,0));
		 JButton apply=new JButton("적용");
		 apply.setFont(new Font("맑은고딕",Font.BOLD,13));
		 apply.setPreferredSize(new Dimension(100,28));
		 
		 JButton help=new JButton("?");
		 help.setFont(new Font("맑은고딕",Font.BOLD,13));
		 
		 btns.setBorder(BorderFactory.createEmptyBorder(0,435,5,5));
		 btns.add(apply);
		 btns.add(help);
		 
		 add(btns,BorderLayout.SOUTH);
		 
		 help.addActionListener(new ActionListener() {
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
