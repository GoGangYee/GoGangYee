package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class LineGraph extends JPanel { // �������׷��� �׷��ִ�Ŭ����
	// ���� : LineGraph(�����ڿ� �������� ���� ��� �ִ� �迭, ������ ����� ���� �����ִ� ����, ���� �������� ����)
	// setDimension���� ũ�� ���� ���ش�. �׷��� �׷��� �˾Ƽ� ���
	int x[]; // x��ǥ �迭
	int y[]; // y��ǥ �迭
	double data[];	//������
	String label[];	//X�࿡ ����� �۾�(��¥)

	LineGraph(double[] data, int multiply, int interval, int k, int startDate, int endDate) { // ������ �迭, ������ ��, ����
		this.data=data;
		int[] x_tmp = new int[k];
		int[] y_tmp = new int[k]; // �ӽ�
		for (int i = 0; i < k; i++) {
			if(i==0)
				x_tmp[0]=50;
			else
				x_tmp[i] = x_tmp[i-1] + interval;
			y_tmp[i] = (int) (data[i] * multiply); // ���ϱ� ���ִ� ����� ���� ��������� �Ѵ�.
			// System.out.println(x_tmp[i]+" "+y_tmp[i]);
			y_tmp[i] = 170 - y_tmp[i] - 30; // �ڹ� �׷����� y��ǥ�� ������ ���� �����ϹǷ� 170���� ���ش�.
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

		g.drawLine(20, 20, 20, 150); // Y�� �׸���
		g.drawLine(20, 150, 730, 150); // X�� �׸���
		g.drawString("��", 5, 15);
		g.drawString("��¥", 710, 165);
		
		for (int i = 0; i < this.x.length; i++) { // �����
			int x = this.x[i];
			int y = this.y[i];
			int ovalW = 7;
			int ovalH = 7;
			g.fillOval(x - 3, y - 3, ovalW, ovalH);
			g.drawString(Double.toString(this.data[i]), x-10, y-10);	//������ ���
			g.drawString(label[i], x-15, 165);	//X�� �� ���
		}

		g.setColor(Color.RED);
		g.drawPolyline(x, y, this.x.length); // ������ �׷��� ���

		setBackground(Color.WHITE);


	}
}