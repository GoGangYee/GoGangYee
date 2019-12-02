package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MaterialView extends JFrame{
	String[] region = {"강남구","강남대로","강동구","강변북로","강북구","강서구","공항대로","관악구","관악산","광진구","구로구","궁동","금천구","남산","노원구","도봉구","도산대로","동대문구","동작구","도산대로","동대문구","동작구","동작대로","마포구","북한산","서대문구","서초구","성동구","성북구","세곡","송파구","시흥대로","신촌로","양천구","영등포구","영등포로","용산구","은평구","정릉로","종로","종로구","중구","중랑구","천호대로","청계천로","한강대로","행주","홍릉로","화랑로"};
	JComboBox<String> localSelect = new JComboBox<>(region);
	JButton apply = new JButton("적용");
	JTextField monthTF1 = new JTextField(2);
	JTextField monthTF2 = new JTextField(2);
	JTextField dayTF1 = new JTextField(2);
	JTextField dayTF2 = new JTextField(2);
	JRadioButton ck1 = new JRadioButton("이산화질소");
    JRadioButton ck2 = new JRadioButton("일산화산소");
    JRadioButton ck3 = new JRadioButton("아황산가스");
    JRadioButton ck4 = new JRadioButton("오존");
    JRadioButton ck5 = new JRadioButton("미세먼지");
    JRadioButton ck6 = new JRadioButton("초미세먼지");
	double[] data1= new double[365];
	int k=0;
	String material="";
	JPanel p1 = new JPanel();		
	
	public MaterialView() {
		setTitle("고갱이");
		
		setLayout(new BorderLayout(10, 10));
		showNorth();
		//showCenter();
		showSouth();
		
		setSize(800, 500);
		setVisible(true);
	}
	
	public void showNorth() {
		JPanel p1 = new JPanel(new BorderLayout());	// 지역, 날짜선택 영역
		JPanel p1_0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p1_4 = new JPanel(new BorderLayout());
		JPanel p1_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// From date Choose
		JPanel p1_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// to date choose
		JPanel p1_5 = new JPanel(new BorderLayout());
		JPanel p1_6 = new JPanel(new FlowLayout(FlowLayout.LEFT));	// From date Choose
		JPanel p1_7 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new BorderLayout());	// 물질선택 칸
		JPanel p2_0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2_1 = new JPanel(new BorderLayout());	// 물질 선택 왼쪽
		JPanel p2_2 = new JPanel(new BorderLayout());	// 물질 선택 오른쪽
		JPanel p2_1_1 = new JPanel(new BorderLayout());
		JPanel p2_2_1 = new JPanel(new BorderLayout());
		JPanel p2_3 = new JPanel(new GridLayout(1,2));
		JPanel panel = new JPanel(new GridLayout(1,2));	// 전체패널
		
		JButton help = new JButton("?");	
		JLabel txt1 = new JLabel("물질별 비교");
		JLabel txt2 = new JLabel("지역 선택");
		JLabel txt3 = new JLabel("날짜 선택");
		JLabel year = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel year1 = new JLabel("2018년");
		JLabel month1 = new JLabel("월");
		JLabel day1 = new JLabel("일");
		JLabel fromTo = new JLabel("~");
		JLabel materialChoice = new JLabel("물질 선택");
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
		ButtonGroup radioBtns=new ButtonGroup();	//물질 중복 선택을 방지하기 위한 버튼그룹
		
        radioBtns.add(ck1);
        radioBtns.add(ck2);
        radioBtns.add(ck3);
        radioBtns.add(ck4);
        radioBtns.add(ck5);
        radioBtns.add(ck6);
        
		localSelect.setPreferredSize(new Dimension(200,25));
		txt1.setFont(new Font("맑은고딕",Font.PLAIN,30));
		help.setFont(new Font("맑은고딕",Font.BOLD,13));
		p2_1_1.setBorder(new TitledBorder (new EtchedBorder(), " ppm "));
		p2_2_1.setBorder(new TitledBorder (new EtchedBorder(), " μg "));
		p2.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		p1.add(p1_0, BorderLayout.NORTH);
		p1.add(p1_4, BorderLayout.CENTER);
		p1_4.add(p1_1, BorderLayout.NORTH);
		p1_4.add(p1_7, BorderLayout.CENTER);
		p1_7.add(p1_3, BorderLayout.WEST);
		p1_7.add(p1_5, BorderLayout.CENTER);
		p1_5.add(p1_2, BorderLayout.NORTH);
		p1_5.add(p1_6, BorderLayout.CENTER);
		p1_0.add(txt1);
		p1_1.add(txt2);
		p1_1.add(localSelect);
		p1_3.add(txt3);
		p1_2.add(year);
		p1_2.add(monthTF1);
		p1_2.add(month);
		p1_2.add(dayTF1);
		p1_2.add(day);
		p1_6.add(fromTo);
		p1_6.add(year1);
		p1_6.add(monthTF2);
		p1_6.add(month1);
		p1_6.add(dayTF2);
		p1_6.add(day1);
		
		p2.add(p2_0, BorderLayout.NORTH);
		p2.add(p2_3, BorderLayout.CENTER);
		p2.add(apply, BorderLayout.SOUTH);
		p2_0.add(materialChoice);
		p2_1.add(p2_1_1, BorderLayout.CENTER);
		p2_2.add(p2_2_1, BorderLayout.CENTER);
		p2_1_1.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
		p2_2_1.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
		p2_3.add(p2_1);
		p2_3.add(p2_2);
		
		panel.add(p1);	// 지역, 날짜선택 칸
		panel.add(p2);	// 물질선택 칸
		
		add(panel, BorderLayout.NORTH);
}
	
	public void showCenter() {	  	      
	      if(material.equals("microdust")==true || material.equals("ultrafinemicrodust")==true) {
	    	  System.out.println("ewew");
	    	  LineGraph graph=new LineGraph(data1,1,50);  
	    	  graph.setPreferredSize(new Dimension(750,170));
		      p1.add(graph);
		      add(p1, BorderLayout.CENTER);
		      repaint();
	      }
	      if(material.equals("co2")) {
	    	  LineGraph graph=new LineGraph(data1,100,50);  
	    	  graph.setPreferredSize(new Dimension(750,170));
		      p1.add(graph);
		      add(p1, BorderLayout.CENTER);
	      }
	      if(material.equals("no2")==true||material.equals("o3")==true||material.equals("so2")==true)
	      {
	    	  System.out.println("ewel");
	    	  LineGraph graph=new LineGraph(data1,2000,50);
	    	  graph.setPreferredSize(new Dimension(750,170));
		      p1.add(graph);
		      add(p1, BorderLayout.CENTER);
	      }
	      p1.revalidate();
	      p1.repaint();
	      k=0;
	      //graph.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));	      	      
	   }
	
	public void showSouth() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton helpB = new JButton("?");
		
		helpB.setFont(new Font("맑은고딕", Font.BOLD, 13));
		
		panel.add(helpB);
		
		helpB.addActionListener(new HelpActionListener ());
		
		
		add(panel, BorderLayout.SOUTH);
		
		 apply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	   				Connection conn=null;
	   				Statement stmt=null;
	   				ResultSet rs=null;

	   				String value="";
	   				String url="jdbc:mysql://localhost/gogang?characterEncoding=UTF-8&serverTimezone=UTC";
	   				
	   				if(ck1.isSelected())
	    				{
	    					material="no2";
	    				}
	    				if(ck2.isSelected())
	    				{
	    					material="o3";
	    				}
	    				if(ck3.isSelected())
	    				{
	    					material="co2";
	    				}
	    				if(ck4.isSelected())
	    				{
	    					material="so2";
	    				}
	    				if(ck5.isSelected())
	    				{
	    					material="microdust";
	    				}
	    				if(ck6.isSelected())
	    				{
	    					material="ultrafinemicrodust";
	    				}
	   				
	   				try {
	   					Class.forName("com.mysql.cj.jdbc.Driver");
	   					
	   					conn=DriverManager.getConnection(url,"root","Pringle!135");
	   					//연결
	   					stmt=conn.createStatement();
	   					
	   					String sql="select "+material+" from gogang"+" where date>='2018"+monthTF1.getText()+dayTF1.getText()
	   					+"'"+" and date<='2018"+monthTF2.getText()+dayTF2.getText()+"'"+" and local='"+localSelect.getSelectedItem().toString()+"'";

	   					System.out.println(sql);
	   					rs=stmt.executeQuery(sql);	   		
	   					
	   					while(rs.next())
					    {
	   						String v="";
					    	v=rs.getString(material)+"\n";
					    	if(rs.getString(material).equals(""))
					    	{
					    		v="0";
					    	}
					    	value+=v;
					    	v="";
					    }
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
	   				String[] data=value.split("\n");	   				
	   				
	   				for(int i=0;i<data.length;i++)
	   				{
	   					data1[i]=Double.parseDouble(data[i]);
	   					k++;
	   				}
	   				for(int i=0;i<data.length;i++)
	   				{
	   					System.out.println(data1[i]);
	   				}		
	   				p1.removeAll();
	   				showCenter();	   				
				}			 
			 });
	}
	
	class LineGraph extends JPanel{   //꺾은선그래프 그려주는클래스
	      //사용법 : LineGraph(생성자에 데이터의 값이 담겨 있는 배열, 정수로 만들기 위해 곱해주는 변수, 간격 설정위한 정수)
	        //setDimension으로 크기 설정 해준다. 그러면 그래프 알아서 출력
	      int x[];   //x좌표 배열
	      int y[];   //y좌표 배열
	      
	      
	      LineGraph(double[] data, int multiply, int interval){   //데이터 배열, 곱해줄 수, 간격
	         int[] x_tmp=new int[k];
	         int[] y_tmp=new int[k];   //임시
	         for(int i=0;i<k;i++) {
	            x_tmp[i]=(i+1)*interval;
	            y_tmp[i]=(int)(data[i] * multiply);   //곱하기 해주는 상수의 수를 조절해줘야 한다.
	            //System.out.println(x_tmp[i]+" "+y_tmp[i]);
	            y_tmp[i]=170-y_tmp[i];   //자바 그래픽은 y좌표가 위에서 부터 시작하므로 300에서 빼준다.
	         } 
	         
	         this.x=x_tmp;
	         this.y=y_tmp;
	         System.out.println(k);
	         for(int i=0;i<k;i++)
	            System.out.println(x[i]+" "+y[i]);
	         //this.y=y;
	         }
	      
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         
	         g.drawLine(30, 10, 30, 150);   //Y축 그리기
	         g.drawLine(30, 150, 670, 150);   //X축 그리기
	         
	         for (int i = 0; i < this.x.length; i++) {   //점찍기
	               int x = this.x[i];
	               int y = this.y[i];
	               int ovalW = 7;
	               int ovalH = 7;
	               g.fillOval(x-3, y-3, ovalW, ovalH);
	            }
	         
	         g.setColor(Color.RED);
	         g.drawPolyline(x,y,this.x.length);   //꺾은선 그래프 출력
	         
	         setBackground(Color.WHITE);      
	         
	      }
	}
}