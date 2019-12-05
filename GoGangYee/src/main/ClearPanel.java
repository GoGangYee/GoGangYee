package main;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

//배경을 투명하게 만들어주는 클래스이다. JPanel과 사용법은 같다.
public class ClearPanel extends JPanel{
	public ClearPanel() {
		setOpaque(false);
	}
	public ClearPanel(LayoutManager l) {
		setLayout(l);
		setOpaque(false);
	}
}