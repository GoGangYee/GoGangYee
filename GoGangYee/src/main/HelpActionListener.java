package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class HelpActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "�̻�ȭ����\r\n" + 
				" * �ڿ� �����ڱ�\r\n" + 
				" * ȣ��⿡ ���� ����\r\n" + 
				"\r\n" + 
				"����\r\n" + 
				" * �� �ڱ�, ���۹� ����\r\n" + 
				"\r\n" + 
				"�ϻ�ȭź��\r\n" + 
				" * ��Ұ��� ����, ����, ������ ����\r\n" + 
				"\r\n" + 
				"��Ȳ�갡��\r\n" + 
				" * ��üȣ��� ��ȯ\r\n" + 
				" * �Ĺ��� ���� ����\r\n" + 
				"\r\n" + 
				"�̼�����\r\n" + 
				" * ��Ȳ�갡���� �����Ͽ� ȣ�����ȯ ����\r\n" + 
				"\r\n" + 
				"�ʹ̼�����\r\n" + 
				" * ��Ȳ�갡���� �����Ͽ� ȣ�����ȯ ����\r\n" + 
				"\r\n" + 
				"��ó - ������û","������ ����",JOptionPane.WARNING_MESSAGE);
	}
}
