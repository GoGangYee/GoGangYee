package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class HelpActionListener implements ActionListener {
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
}
