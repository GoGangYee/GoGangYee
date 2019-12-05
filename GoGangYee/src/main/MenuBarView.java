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
	JMenuItem saveMI = new JMenuItem("저장하기");
	JMenuItem loadMI = new JMenuItem("불러오기");
	JMenuItem commitMI = new JMenuItem("적용하기");
	JMenu viewMenu = new JMenu("View");
	JMenuItem backgroundMI = new JMenu("배경화면 바꾸기");
	JMenuItem defaultBG = new JMenuItem("기본");
	JMenuItem snowBG = new JMenuItem("눈");
	JMenuItem yellowdustBG = new JMenuItem("황사");
	JMenuItem nightBG = new JMenuItem("밤");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem saveAir = new JMenuItem("공기정화 동참법");
	JMenuItem materialInfo = new JMenuItem("물질별 정보");
	JMenu infoMenu = new JMenu("Info");
	JMenuItem programInfo = new JMenuItem("프로그램 정보");
	JMenuItem supportInfo = new JMenuItem("후원하기");
	JPanel panel = new JPanel();
	ImagePanel p;
	ImagePanel m;	//메인뷰꺼
	
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
		fileMenu.addSeparator(); // 분리선 삽입
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






