package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class LineGraph extends JPanel { // 꺾은선그래프 그려주는클래스
	// 사용법 : LineGraph(생성자에 데이터의 값이 담겨 있는 배열, 정수로 만들기 위해 곱해주는 변수, 간격 설정위한 정수)
	// setDimension으로 크기 설정 해준다. 그러면 그래프 알아서 출력
	int x[]; // x좌표 배열
	int y[]; // y좌표 배열
	double data[];	//데이터
	String label[];	//X축에 띄워줄 글씨(날짜)

	LineGraph(double[] data, int multiply, int interval, int k, int startDate, int endDate) { // 데이터 배열, 곱해줄 수, 간격
		this.data=data;
		int[] x_tmp = new int[k];
		int[] y_tmp = new int[k]; // 임시
		for (int i = 0; i < k; i++) {
			if(i==0)
				x_tmp[0]=50;
			else
				x_tmp[i] = x_tmp[i-1] + interval;
			y_tmp[i] = (int) (data[i] * multiply); // 곱하기 해주는 상수의 수를 조절해줘야 한다.
			// System.out.println(x_tmp[i]+" "+y_tmp[i]);
			y_tmp[i] = 170 - y_tmp[i] - 30; // 자바 그래픽은 y좌표가 위에서 부터 시작하므로 170에서 빼준다.
		}

		this.x = x_tmp;
		this.y = y_tmp;
		label=new String[endDate - startDate + 1];
		int tmp=startDate;
		for(int i=0;i<(endDate-startDate+1);i++) {				
			if(tmp==132)
				tmp=201;
			else if(tmp==229)
				tmp=301;
			else if(tmp==332)
				tmp=401;
			else if(tmp==431)
				tmp=501;
			else if(tmp==532)
				tmp=601;
			else if(tmp==631)
				tmp=701;
			else if(tmp==732)
				tmp=801;
			else if(tmp==832)
				tmp=901;
			else if(tmp==931)
				tmp=1001;
			else if(tmp==1032)
				tmp=1101;
			else if(tmp==1131)
				tmp=1201;
			
			label[i]=String.format("%04d", tmp++);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawLine(20, 20, 20, 150); // Y축 그리기
		g.drawLine(20, 150, 730, 150); // X축 그리기
		g.drawString("농도", 5, 15);
		g.drawString("날짜", 710, 165);
		
		for (int i = 0; i < this.x.length; i++) { // 점찍기
			int x = this.x[i];
			int y = this.y[i];
			int ovalW = 7;
			int ovalH = 7;
			g.fillOval(x - 3, y - 3, ovalW, ovalH);
			g.drawString(Double.toString(this.data[i]), x-10, y-10);	//데이터 출력
			g.drawString(label[i], x-15, 165);	//X축 값 출력
		}

		g.setColor(Color.RED);
		g.drawPolyline(x, y, this.x.length); // 꺾은선 그래프 출력

		setBackground(Color.WHITE);


	}
}