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
		setTitle("���� ���� ����");
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
		
		// Open �޴������ۿ� Action �����ʸ� ����Ѵ�.
		openItem.addActionListener(new OpenActionListener());
		fileMenu.add(openItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		
		OpenActionListener() {
			chooser = new JFileChooser(); // ���� ���̾�α� ����
		}
		
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images",  // ���� �̸��� â�� ��µ� ���ڿ�
					"jpg", "gif");		 // ���� ���ͷ� ���Ǵ� Ȯ����
			chooser.setFileFilter(filter); // ���� ���̾�α׿� ���� ���� ����
			
			// ���� ���̾�α� ���
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { // ����ڰ� â�� ������ �ݾҰų� ��� ��ư�� ���� ���
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// ����ڰ� ������ �����ϰ� "����" ��ư�� ���� ���
			String filePath = chooser.getSelectedFile().getPath(); // ���� ��θ��� �˾ƿ´�.
			imageLabel.setIcon(new ImageIcon(filePath)); // ������ �ε��Ͽ� �̹��� ���̺� ����Ѵ�.
			System.out.println("���� ��� : " + filePath);
			imagePath.setText(filePath);
			
			pack();
		}
	}
	
	public static void main(String[] args) {
		new MenuAndFileDialogEx11();

	}

}
