package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MainHelpActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, 
				"1. ������ ���ฦ �����մϴ�\r\n\n" + 
				"2. ���߱����� �̿��մϴ�\r\n\n" + 
				"3. ��⹰ �и� ����\r\n\n" + 
				"4. ����� ���� �Ȱų� �����Ÿ� ž�ϴ�\r\n\n" + 
				"5 .�����,������,��ȸ���� �ﰩ�ϴ�\r\n\n" + 
				"6. �ſ������� 120�� �Ű��մϴ�\r\n\n" + 
				"7. �� Ȧ�� ������ �����մϴ�\r\n\n" + 
				"8. �����¿��� ���Ÿ� �����մϴ�\r\n\n" + 
				"9. ������ȭ�Ĺ��� Ű��ϴ�\r\n\n" + 
				"10. �丮 �� ��ȭ ���̸� �ﰩ�ϴ�\r\n\n"   
				,"������ȭ���",JOptionPane.WARNING_MESSAGE);
	}
}
