package main;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//배경 이미지 만들어주는 클래스. 모든 컴포넌트 및 (투명)패널을 이 패녈에 넣어주면 된다.
public class ImagePanel extends JPanel {
	public static BufferedImage img=null;

	public ImagePanel() {
		try {
			if(img==null)
				img = ImageIO.read(new File("image/sky.png")); // default는 하늘
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
	}

	public ImagePanel(LayoutManager l) {
		try {
			img = ImageIO.read(new File("image/sky.png")); // default는 하늘
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		this.setLayout(l);
	}

	static public void changeImage(int num) { // 사진 바꾸기 함수
		if (num == 1) { // 하늘
			try {
				img = ImageIO.read(new File("image/sky.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
				System.exit(0);
			}
		}
		if (num == 2) { // 눈
			try {
				img = ImageIO.read(new File("image/snow.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
				System.exit(0);
			}
		}
		if (num == 3) { // 황사
			try {
				img = ImageIO.read(new File("image/yellodust.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
				System.exit(0);
			}
		}
		if (num == 4) { // 밤하늘
			try {
				img = ImageIO.read(new File("image/night.png"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
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
	ImagePanel p;
	ImagePanel m;
	
	public ChangeBackGroundActionListener(int i, ImagePanel m, ImagePanel p) {
		this.flag = i;
		this.p=p;
		this.m=m;
	}

	public void actionPerformed(ActionEvent e) {
		ImagePanel.changeImage(this.flag);
		p.revalidate();
		p.repaint();
		m.revalidate();
		m.repaint();
	}
}