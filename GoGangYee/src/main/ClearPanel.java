package main;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

//����� �����ϰ� ������ִ� Ŭ�����̴�. JPanel�� ������ ����.
public class ClearPanel extends JPanel{
	public ClearPanel() {
		setBackground(new Color(255,255,255,0));
	}
	public ClearPanel(LayoutManager l) {
		setLayout(l);
		setBackground(new Color(255,255,255,0));
	}
}