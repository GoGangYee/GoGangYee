package main;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//��� �̹��� ������ִ� Ŭ����. ��� ������Ʈ �� (����)�г��� �� �г㿡 �־��ָ� �ȴ�.
public class ImagePanel extends JPanel {
	BufferedImage img;

	public ImagePanel() {
		try {
			img = ImageIO.read(new File("image/sky.png")); // default�� �ϴ�
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
	}

	public ImagePanel(LayoutManager l) {
		try {
			img = ImageIO.read(new File("image/sky.png")); // default�� �ϴ�
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		this.setLayout(l);
	}

	public void changeImage(int num) { // ���� �ٲٱ� �Լ�
		if (num == 1) { // �ϴ�
			try {
				img = ImageIO.read(new File("image/sky.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
				System.exit(0);
			}
		}
		if (num == 2) { // ��
			try {
				img = ImageIO.read(new File("image/snow.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
				System.exit(0);
			}
		}
		if (num == 3) { // Ȳ��
			try {
				img = ImageIO.read(new File("image/yellodust.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
				System.exit(0);
			}
		}
		if (num == 4) { // ���ϴ�
			try {
				img = ImageIO.read(new File("image/night.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
				System.exit(0);
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
}

class ChangeBackGroundActionListener implements ActionListener {

	int flag = 1;
	ImagePanel ip = new ImagePanel();
	
	public ChangeBackGroundActionListener(int i) {
		this.flag = i;
	}

	public void actionPerformed(ActionEvent e) {
		ip.changeImage(flag);
		(MainView.p5).add(ip);
	}
}