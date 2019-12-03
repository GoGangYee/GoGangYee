package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class LineGraph extends JPanel { // 꺾은선그래프 그려주는클래스
	// 사용법 : LineGraph(생성자에 데이터의 값이 담겨 있는 배열, 정수로 만들기 위해 곱해주는 변수, 간격 설정위한 정수)
	// setDimension으로 크기 설정 해준다. 그러면 그래프 알아서 출력
	int x[]; // x좌표 배열
	int y[]; // y좌표 배열

	LineGraph(double[] data, int multiply, int interval, int k) { // 데이터 배열, 곱해줄 수, 간격
		int[] x_tmp = new int[k];
		int[] y_tmp = new int[k]; // 임시
		for (int i = 0; i < k; i++) {
			x_tmp[i] = (i + 1) * interval;
			y_tmp[i] = (int) (data[i] * multiply); // 곱하기 해주는 상수의 수를 조절해줘야 한다.
			// System.out.println(x_tmp[i]+" "+y_tmp[i]);
			y_tmp[i] = 170 - y_tmp[i]; // 자바 그래픽은 y좌표가 위에서 부터 시작하므로 300에서 빼준다.
		}

		this.x = x_tmp;
		this.y = y_tmp;
		System.out.println(k);
		for (int i = 0; i < k; i++)
			System.out.println(x[i] + " " + y[i]);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawLine(30, 10, 30, 150); // Y축 그리기
		g.drawLine(30, 150, 670, 150); // X축 그리기

		for (int i = 0; i < this.x.length; i++) { // 점찍기
			int x = this.x[i];
			int y = this.y[i];
			int ovalW = 7;
			int ovalH = 7;
			g.fillOval(x - 3, y - 3, ovalW, ovalH);
		}

		g.setColor(Color.RED);
		g.drawPolyline(x, y, this.x.length); // 꺾은선 그래프 출력

		setBackground(Color.WHITE);

	}
}