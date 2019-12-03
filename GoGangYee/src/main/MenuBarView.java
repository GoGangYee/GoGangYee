package main;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBarView extends JFrame {
	
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem saveMI = new JMenuItem("�����ϱ�");
	JMenuItem loadMI = new JMenuItem("�ҷ�����");
	JMenu viewMenu = new JMenu("View");
	JMenuItem backgroundMI = new JMenuItem("���ȭ�� �ٲٱ�");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem saveAir = new JMenuItem("������ȭ ������");
	JMenuItem materialInfo = new JMenuItem("������ ����");
	JMenu infoMenu = new JMenu("Info");
	JMenuItem programInfo = new JMenuItem("���α׷� ����");
	JMenuItem supportInfo = new JMenuItem("�Ŀ��ϱ�");
	JPanel panel = new JPanel();
	
	public JMenuBar showMenuBar() {
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		menuBar.add(infoMenu);
		fileMenu.add(saveMI);
		fileMenu.add(loadMI);
		viewMenu.add(backgroundMI);
		helpMenu.add(saveAir);
		helpMenu.add(materialInfo);
		infoMenu.add(programInfo);
		infoMenu.add(supportInfo);
		
		return menuBar;
		
	}
}
