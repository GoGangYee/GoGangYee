package main;

import java.awt.Container;

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
	JMenuItem commitMI = new JMenuItem("�����ϱ�");
	JMenu viewMenu = new JMenu("View");
	JMenuItem backgroundMI = new JMenu("���ȭ�� �ٲٱ�");
	JMenuItem defaultBG = new JMenuItem("�⺻");
	JMenuItem snowBG = new JMenuItem("��");
	JMenuItem yellowdustBG = new JMenuItem("Ȳ��");
	JMenuItem nightBG = new JMenuItem("��");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem saveAir = new JMenuItem("������ȭ ������");
	JMenuItem materialInfo = new JMenuItem("������ ����");
	JMenu infoMenu = new JMenu("Info");
	JMenuItem programInfo = new JMenuItem("���α׷� ����");
	JMenuItem supportInfo = new JMenuItem("�Ŀ��ϱ�");
	JPanel panel = new JPanel();
	ImagePanel p;
	ImagePanel m;	//���κ䲨
	
	public MenuBarView(ImagePanel m, ImagePanel p) {
		this.m=m;
		this.p=p;
	}

	public JMenuBar showMenuBar() {

		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		menuBar.add(infoMenu);
		fileMenu.add(saveMI);
		fileMenu.addSeparator(); // �и��� ����
		fileMenu.add(loadMI);
		fileMenu.add(commitMI);
		viewMenu.add(backgroundMI);
		backgroundMI.add(defaultBG);
		backgroundMI.add(snowBG);
		backgroundMI.add(yellowdustBG);
		backgroundMI.add(nightBG);
		helpMenu.add(saveAir);
		helpMenu.add(materialInfo);
		infoMenu.add(programInfo);
		infoMenu.add(supportInfo);
		
		FileAct file = new FileAct();
		InfoAct info = new InfoAct();

		saveMI.addActionListener(file.new SaveActionListener());
		loadMI.addActionListener(file.new OpenActionListener());
		commitMI.addActionListener(file.new CommitActionListener());
		saveAir.addActionListener(info.new AirSaveActionListener());
		materialInfo.addActionListener(info.new MetarialInfoActionListener());
		programInfo.addActionListener(info.new ProgramInfoActionListener());
		supportInfo.addActionListener(info.new SupportInfoActionListener());
		defaultBG.addActionListener(new ChangeBackGroundActionListener(1,m,p));
		snowBG.addActionListener(new ChangeBackGroundActionListener(2,m,p));
		yellowdustBG.addActionListener(new ChangeBackGroundActionListener(3,m,p));
		nightBG.addActionListener(new ChangeBackGroundActionListener(4,m,p));
		
		
		return menuBar;
	}
}






