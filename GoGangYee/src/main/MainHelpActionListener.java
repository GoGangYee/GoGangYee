package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MainHelpActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, 
				"1. 에너지 절약를 절약합니다\r\n\n" + 
				"2. 대중교통을 이용합니다\r\n\n" + 
				"3. 폐기물 분리 배출\r\n\n" + 
				"4. 가까운 곳은 걷거나 자전거를 탑니다\r\n\n" + 
				"5 .급출발,급제동,공회전을 삼갑니다\r\n\n" + 
				"6. 매연차량은 120에 신고합니다\r\n\n" + 
				"7. 나 홀로 운행을 자제합니다\r\n\n" + 
				"8. 경유승용차 구매를 자제합니다\r\n\n" + 
				"9. 공기정화식물을 키웁니다\r\n\n" + 
				"10. 요리 시 직화 구이를 삼갑니다\r\n\n"   
				,"공기정화운동법",JOptionPane.WARNING_MESSAGE);
	}
}
