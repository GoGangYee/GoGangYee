package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuAndFileDialogEx11 extends JFrame{
	
	Container contentPane;
	JLabel imageLabel = new JLabel();
	JLabel imagePath = new JLabel();
	
	MenuAndFileDialogEx11(){
		setTitle("파일 열기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(imageLabel);
		contentPane.add(imagePath);
		creatMenu();
		setSize(300,200);
		setVisible(true);
	}
	
	void creatMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		
		// Open 메뉴아이템에 Action 리스너를 등록한다.
		openItem.addActionListener(new OpenActionListener());
		fileMenu.add(openItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		
		OpenActionListener() {
			chooser = new JFileChooser(); // 파일 다이얼로그 생성
		}
		
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images",  // 파일 이름에 창에 출력될 문자열
					"jpg", "gif");		 // 파일 필터로 사용되는 확장자
			chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정
			
			// 파일 다이얼로그 출력
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가 창을 강제로 닫았거나 취소 버튼을 누른 경우
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
			String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
			imageLabel.setIcon(new ImageIcon(filePath)); // 파일을 로딩하여 이미지 레이블에 출력한다.
			System.out.println("파일 경로 : " + filePath);
			imagePath.setText(filePath);
			
			pack();
		}
	}
	
	public static void main(String[] args) {
		new MenuAndFileDialogEx11();

	}

}
