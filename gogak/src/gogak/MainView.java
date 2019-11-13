package gogak;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame{
	MainView(){
		setTitle("Main View");
		EtchedBorder eborder;
		 
		JPanel p=new JPanel();
		JPanel p1=new JPanel(new FlowLayout());
		JPanel p2=new JPanel(new GridLayout(2,2,10,10));
		JPanel p3=new JPanel(new GridLayout(2,1,5,5));
		JPanel p4=new JPanel();
		
		JLabel label=new JLabel("°í  °»  ÀÌ");
		JLabel FileNameL=new JLabel("");
		JButton search=new JButton("Ã£±â");
		JButton commit=new JButton("È®ÀÎ");
		JButton material=new JButton("¹°Áúº° ºñ±³");
		JButton local=new JButton("Áö¿ªº° ºñ±³");
		JButton date=new JButton("³¯Â¥º° ºñ±³");
		JButton MandD=new JButton("¼öÁ¤ ¹× »èÁ¦");
		JButton help=new JButton("?");
		
		eborder=new EtchedBorder(EtchedBorder.RAISED);
		FileNameL.setBorder(eborder);
		
		FileNameL.setPreferredSize(new Dimension(450,28));
		p2.setPreferredSize(new Dimension(10,1));
		label.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,30));
		material.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		local.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		date.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		MandD.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		help.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		p3.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		p2.setBorder(BorderFactory.createEmptyBorder(0,100,50,100));
		p4.setBorder(BorderFactory.createEmptyBorder(0,730,0,0));
		
		p.add(label);
		p1.add(FileNameL);
		p1.add(search);
		p1.add(commit);
		p2.add(material);
		p2.add(local);
		p2.add(date);
		p2.add(MandD);
		p3.add(p);
		p3.add(p1);
		p4.add(help);
		
		super.setLayout(new BorderLayout(3,0));
		
		date.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new DateView();
			}
		});
		
		MandD.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ModifyDB();
			}
		});
		
		getContentPane().add(p3,"North");
		getContentPane().add(p2,"Center");
		getContentPane().add(p4,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainView();
	}
}