package main;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

//����� �����ϰ� ������ִ� Ŭ�����̴�. JPanel�� ������ ����.
public class ClearPanel extends JPanel{
	public ClearPanel() {
		setOpaque(false);
	}
	public ClearPanel(LayoutManager l) {
		setLayout(l);
		setOpaque(false);
	}
}