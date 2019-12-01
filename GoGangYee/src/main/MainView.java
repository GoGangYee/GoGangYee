package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainView extends JFrame{
	JPanel p=new JPanel();
	JPanel p1=new JPanel(new FlowLayout());
	JPanel p2=new JPanel(new GridLayout(2,2,10,10));
	JPanel p3=new JPanel(new GridLayout(2,1,5,5));
	JPanel p4=new JPanel();
	
	JLabel label=new JLabel("고  갱  이");
	JLabel FileNameL=new JLabel("");
	JButton search=new JButton("찾기");
	JButton commit=new JButton("확인");
	JButton material=new JButton("물질별 비교");
	JButton local=new JButton("지역별 비교");
	JButton date=new JButton("날짜별 비교");
	JButton MandD=new JButton("수정 및 삭제");
	JButton help=new JButton("?");
	
	MainView(){
		setTitle("고갱이");
		EtchedBorder eborder;
		
		eborder=new EtchedBorder(EtchedBorder.RAISED);
		FileNameL.setBorder(eborder);
		
		FileNameL.setPreferredSize(new Dimension(450,28));
		p2.setPreferredSize(new Dimension(10,1));
		label.setFont(new Font("맑은고딕",Font.PLAIN,30));
		material.setFont(new Font("맑은고딕",Font.BOLD,20));
		local.setFont(new Font("맑은고딕",Font.BOLD,20));
		date.setFont(new Font("맑은고딕",Font.BOLD,20));
		MandD.setFont(new Font("맑은고딕",Font.BOLD,20));
		help.setFont(new Font("맑은고딕",Font.BOLD,13));
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
		
		local.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new LocalView();
			}
		});
		
		material.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new MaterialView();
			}
		});
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1. 에너지 절약를 절약합니다\r\n\n" + 
						"2. 대중교통을 이용합니다\r\n\n" + 
						"3. 폐기물 분리 배출\r\n\n" + 
						"4. 가까운 곳은 걷거나 자전거를 탑니다\r\n\n" + 
						"5 .급출발,급제동,공회전을 삼갑니다\r\n\n" + 
						"6. 매연차량은 120에 신고합니다\r\n\n" + 
						"7. 나 홀로 운행을 자제합니다\r\n\n" + 
						"8. 경유승용차 구매를 자제합니다\r\n\n" + 
						"9. 공기정화식물을 키웁니다\r\n\n" + 
						"10. 요리 시 직화 구이를 삼갑니다\r\n\n"   
						,"공기정화운동법",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		search.addActionListener(new OpenActionListener());
		
		getContentPane().add(p3,"North");
		getContentPane().add(p2,"Center");
		getContentPane().add(p4,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setVisible(true);
		
		commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				Statement stmt=null;
				ResultSet rs=null;
				String url="jdbc:mysql://localhost/gogang?characterEncoding=UTF-8&serverTimezone=UTC";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn=DriverManager.getConnection(url,"root","asd970712!@");
					//연결
					stmt=conn.createStatement();
					String sql="LOAD DATA INFILE '";
					sql+=FileNameL.getText();
					sql+="' INTO TABLE gogang FIELDS TERMINATED BY ','";
					sql=sql.replace("\\","/");
					System.out.println(sql);
					rs=stmt.executeQuery(sql);
				}
				catch(ClassNotFoundException e1) {
					System.out.println("드라이버 로딩 실패");
				}
				catch(SQLException e1) {
					System.out.println("에러: "+e1);
				}
				finally {
					try {
						if(conn !=null && !conn.isClosed()) {
							conn.close();
						}
					}
				
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
		});
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				Connection conn=null;
				Statement stmt1=null;
				ResultSet rs1=null;
				int rs=0;
				String url="jdbc:mysql://localhost/gogang?characterEncoding=UTF-8&serverTimezone=UTC";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn=DriverManager.getConnection(url,"root","asd970712!@");
					//연결
					stmt1=conn.createStatement();
				
					String sql="delete from gogang";
					String sql1="select * from gogang " + 
							"into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gogang.csv' " + 
							"character set utf8 " + 
							"fields terminated by ', ' " + 
							"lines terminated by '\n'";
					
					rs1=stmt1.executeQuery(sql1);
					rs=stmt1.executeUpdate(sql);
				}
				catch(ClassNotFoundException e1) {
					System.out.println("드라이버 로딩 실패");
				}
				catch(SQLException e1) {
					System.out.println("에러: "+e1);
				}
				finally {
					try {
						if(conn !=null && !conn.isClosed()) {
							conn.close();
						}
					}
				
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				}
			}		
		});
	}
	
	class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		
		OpenActionListener() {
			chooser = new JFileChooser(); // 파일 다이얼로그 생성
		}
		
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가 창을 강제로 닫았거나 취소 버튼을 누른 경우
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
			String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
			FileNameL.setText(filePath);
			System.out.println(FileNameL.getText());
		}
	}
	
	public static void main(String[] args) {
		new MainView();
	}
}

