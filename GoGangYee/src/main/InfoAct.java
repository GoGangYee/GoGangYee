package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InfoAct {
	//물질별 설명 액션 리스너
	class MetarialInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"이산화질소\r\n" + " * 코와 인후자극\r\n" + " * 호흡기에 나쁜 영향\r\n" + "\r\n" + "오존\r\n" + " * 눈 자극, 농작물 피해\r\n"
							+ "\r\n" + "일산화탄소\r\n" + " * 산소공급 저조, 두통, 현기증 유발\r\n" + "\r\n" + "아황산가스\r\n" + " * 인체호흡기 질환\r\n"
							+ " * 식물의 성장 방해\r\n" + "\r\n" + "미세먼지\r\n" + " * 아황산가스와 결합하여 호흡기질환 유발\r\n" + "\r\n"
							+ "초미세먼지\r\n" + " * 아황산가스와 결합하여 호흡기질환 유발\r\n" + "\r\n" + "출처 - 수원시청",
					"물질별 설명", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// 프로그램 정보 액션 리스너
	class ProgramInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"\n2019 2학기 고급객체지향 프로그래밍 프로젝트 \"고갱이\" \n\n" + "구성 \n팀장: 이연중     역할: DB연동 기계\n"
							+ "팀원: 강영우     역할: 치어리더\n" + "팀원: 양수영     역할: 코딩기계\n" + "팀원: 박지민     역할: 디자이너\n\n" + "발표일자\n"
							+ "2019년 12월 10일\n\n" + "ver.1.0.1\n",
					null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// 후원정보
	class SupportInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"\n고갱이 후원정보\n\n" + "예금주명: 강영우\n" + "은행: 카카오뱅크\n" + "계좌번호: 3333-09-6660126\n\n" + "후원을 기다립니다...", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	// 공기운동 동참법 액션리스너
	class AirSaveActionListener implements ActionListener {
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

}

