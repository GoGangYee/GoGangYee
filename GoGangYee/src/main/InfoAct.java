package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InfoAct {
	//������ ���� �׼� ������
	class MetarialInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"�̻�ȭ����\r\n" + " * �ڿ� �����ڱ�\r\n" + " * ȣ���⿡ ���� ����\r\n" + "\r\n" + "����\r\n" + " * �� �ڱ�, ���۹� ����\r\n"
							+ "\r\n" + "�ϻ�ȭź��\r\n" + " * ��Ұ��� ����, ����, ������ ����\r\n" + "\r\n" + "��Ȳ�갡��\r\n" + " * ��üȣ���� ��ȯ\r\n"
							+ " * �Ĺ��� ���� ����\r\n" + "\r\n" + "�̼�����\r\n" + " * ��Ȳ�갡���� �����Ͽ� ȣ������ȯ ����\r\n" + "\r\n"
							+ "�ʹ̼�����\r\n" + " * ��Ȳ�갡���� �����Ͽ� ȣ������ȯ ����\r\n" + "\r\n" + "��ó - ������û",
					"������ ����", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ���α׷� ���� �׼� ������
	class ProgramInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"\n2019 2�б� ���ް�ü���� ���α׷��� ������Ʈ \"������\" \n\n" + "���� \n����: �̿���     ����: DB���� ���\n"
							+ "����: ������     ����: ġ���\n" + "����: �����     ����: �ڵ����\n" + "����: ������     ����: �����̳�\n\n" + "��ǥ����\n"
							+ "2019�� 12�� 10��\n\n" + "ver.1.0.1\n",
					null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// �Ŀ�����
	class SupportInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"\n������ �Ŀ�����\n\n" + "�����ָ�: ������\n" + "����: īī����ũ\n" + "���¹�ȣ: 3333-09-6660126\n\n" + "�Ŀ��� ��ٸ��ϴ�...", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	// ���� ������ �׼Ǹ�����
	class AirSaveActionListener implements ActionListener {
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

}
