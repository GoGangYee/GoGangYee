package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class LineGraph extends JPanel { // �������׷��� �׷��ִ�Ŭ����
	// ���� : LineGraph(�����ڿ� �������� ���� ��� �ִ� �迭, ������ ����� ���� �����ִ� ����, ���� �������� ����)
	// setDimension���� ũ�� ���� ���ش�. �׷��� �׷��� �˾Ƽ� ���
	int x[]; // x��ǥ �迭
	int y[]; // y��ǥ �迭

	LineGraph(double[] data, int multiply, int interval, int k) { // ������ �迭, ������ ��, ����
		int[] x_tmp = new int[k];
		int[] y_tmp = new int[k]; // �ӽ�
		for (int i = 0; i < k; i++) {
			x_tmp[i] = (i + 1) * interval;
			y_tmp[i] = (int) (data[i] * multiply); // ���ϱ� ���ִ� ����� ���� ��������� �Ѵ�.
			// System.out.println(x_tmp[i]+" "+y_tmp[i]);
			y_tmp[i] = 170 - y_tmp[i]; // �ڹ� �׷����� y��ǥ�� ������ ���� �����ϹǷ� 300���� ���ش�.
		}

		this.x = x_tmp;
		this.y = y_tmp;
		System.out.println(k);
		for (int i = 0; i < k; i++)
			System.out.println(x[i] + " " + y[i]);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawLine(30, 10, 30, 150); // Y�� �׸���
		g.drawLine(30, 150, 670, 150); // X�� �׸���

		for (int i = 0; i < this.x.length; i++) { // �����
			int x = this.x[i];
			int y = this.y[i];
			int ovalW = 7;
			int ovalH = 7;
			g.fillOval(x - 3, y - 3, ovalW, ovalH);
		}

		g.setColor(Color.RED);
		g.drawPolyline(x, y, this.x.length); // ������ �׷��� ���

		setBackground(Color.WHITE);

	}
}