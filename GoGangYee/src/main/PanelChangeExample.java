package main;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
 
@SuppressWarnings("serial")
class JPanel01 extends JPanel { // 1번째 패널
	public String[] region = { "강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구", "구로구", "궁동", "금천구",
			"남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구",
			"성동구", "성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구",
			"중랑구", "천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };
	public ButtonGroup radioBtns = new ButtonGroup(); // 물질 중복 선택 방지 위한 라디오 버튼
	public JRadioButton ck1 = new JRadioButton("이산화질소");
	public JRadioButton ck2 = new JRadioButton("일산화산소");
	public JRadioButton ck3 = new JRadioButton("아황산가스");
	public JRadioButton ck4 = new JRadioButton("오존");
	public JRadioButton ck5 = new JRadioButton("미세먼지");
	public JRadioButton ck6 = new JRadioButton("초미세먼지");
	public JTextField t1 = new JTextField(2); // 월 입력
	public JTextField t2 = new JTextField(2); // 일 입력
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	
    public JPanelTest win;
    public JPanel p1 = new JPanel();
    public JPanel panel = new JPanel(new FlowLayout());
    public JToolBar toolBar;
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    
    public JPanel01(JPanelTest win) {
        this.win = win;
        setLayout(null);
        setLayout(new BorderLayout(10, 10));
        showForm();
		// 툴바 생성
		toolBar = new JToolBar("Modify ToolBar");
		toolBar.setBackground(Color.LIGHT_GRAY);
		// 버튼 생성
		b1 = new JButton("조회하기");
		b2 = new JButton("추가하기");
		b3 = new JButton("수정하기");
		b4 = new JButton("삭제하기");
		
		// 툴바에 메뉴로 사용할 컴포넌트 삽입
		toolBar.add(b1);
		toolBar.addSeparator();
		toolBar.add(b2);
		toolBar.addSeparator();
		toolBar.add(b3);
		toolBar.addSeparator();
		toolBar.add(b4);
		toolBar.addSeparator();
		
		// 툴바를 추가함.
		p1.add(toolBar);
		panel.add(p1);
		add(panel, BorderLayout.SOUTH);
        
		// 조회하기 버튼을 클릭하면 실행하는 리스너
        b1.addActionListener(new ApplyActionListener());
        // 입력하기 버튼을 클릭하면 실행하는 리스너
        b2.addActionListener(new CreateActionListener());
        // 수정하기 버튼을 클릭하면 실행하는 리스너
        b3.addActionListener(new ModifyActionListener());
        // 삭제하기 버튼을 클릭하면 실행하는 리스너
        b4.addActionListener(new DeleteActionListener());
    }
    
    private void showForm() {
    	JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel p1 = new JPanel(new BorderLayout()); // 지역날짜선택 + 물질선택
		JPanel p2 = new JPanel(new BorderLayout()); // 지역선택 + 날짜선택
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 날짜선택
		JPanel p4_1 = new JPanel(new FlowLayout());
		JPanel p5 = new JPanel(new BorderLayout()); // 물질선택
		JPanel p6 = new JPanel(); // 단위 선택 라디오 버튼
		JPanel p7 = new JPanel(new GridLayout(1, 2)); // 물질 선택 박스 모음
		JPanel p7_0 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 물질선택란
		JPanel p7_1 = new JPanel(new BorderLayout());
		JPanel p7_2 = new JPanel(new BorderLayout());
		JPanel ppmPanel = new JPanel(new BorderLayout());
		JPanel μgPanel = new JPanel(new BorderLayout());
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("조회하기");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("조회한 데이터입니다.");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
		add(Eastpanel, BorderLayout.CENTER);
		
		JLabel lbl1 = new JLabel("날짜 선택");
		JLabel lbl2 = new JLabel("지역 선택");
		JLabel lbl3 = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel lbl4 = new JLabel("물질 선택");
		
		cb.setPreferredSize(new Dimension(200, 25));
		
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
	
		radioBtns.add(ck1);
		radioBtns.add(ck2);
		radioBtns.add(ck3);
		radioBtns.add(ck4);
		radioBtns.add(ck5);
		radioBtns.add(ck6);
	
		ppmPanel.setBorder(new TitledBorder(new EtchedBorder(), " ppm "));
		μgPanel.setBorder(new TitledBorder(new EtchedBorder(), " μg "));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
	
		Westpanel.add(p1);
		
		p1.add(p2, BorderLayout.NORTH);
		p1.add(p5, BorderLayout.CENTER);
	
		p2.add(p3, BorderLayout.NORTH);
		p2.add(p4, BorderLayout.CENTER);
		p3.add(lbl2);
		p3.add(cb);
		p4.add(lbl1);
		p4.add(p4_1);
		p4_1.add(lbl3);
		p4_1.add(t1);
		p4_1.add(month);
		p4_1.add(t2);
		p4_1.add(day);
	
		p5.add(p7_0, BorderLayout.NORTH);
		p5.add(p7, BorderLayout.CENTER);
		p7.add(p7_1);
		p7.add(p7_2);
		p7_0.add(lbl4);
		p7_1.add(ppmPanel, BorderLayout.CENTER);
		p7_2.add(μgPanel, BorderLayout.CENTER);
	
		ppmPanel.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
	
		μgPanel.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
	
		add(Westpanel, BorderLayout.WEST);
		
	}
    
    // 조회하기 버튼을 클릭하면 해당 값을 조회함
    class ApplyActionListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    }
    
    // 입력하기 전환 리스너
    class CreateActionListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		win.change("create");
    	}
    }
    
    // 수정하기 전환 리스너
	class ModifyActionListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("modify");
        }
    }
	
	// 삭제하기 전환 리스너
	class DeleteActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("delete");
		}
	}
}
 
//수정하기 패널 클래스
@SuppressWarnings("serial")
class Modify extends JPanel { 
	public String[] region = { "강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구", "구로구", "궁동", "금천구",
			"남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구",
			"성동구", "성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구",
			"중랑구", "천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };
	public ButtonGroup radioBtns = new ButtonGroup(); // 물질 중복 선택 방지 위한 라디오 버튼
	public JRadioButton ck1 = new JRadioButton("이산화질소");
	public JRadioButton ck2 = new JRadioButton("일산화산소");
	public JRadioButton ck3 = new JRadioButton("아황산가스");
	public JRadioButton ck4 = new JRadioButton("오존");
	public JRadioButton ck5 = new JRadioButton("미세먼지");
	public JRadioButton ck6 = new JRadioButton("초미세먼지");
	public JButton apply = new JButton("조회");
	public JTextField t3 = new JTextField(10); // 수정할 데이터 입력 영역
	public JTextField t1 = new JTextField(2); // 월 입력
	public JTextField t2 = new JTextField(2); // 일 입력
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	public JButton btn = new JButton("뒤로가기");
	public JPanelTest win;
 
    public Modify(JPanelTest win) {
        setLayout(null);
        this.win = win;
        setLayout(new BorderLayout(10,10));
        
        showForm();
        
        btn.addActionListener(new MyActionListener());
    }
    
    void showForm() {
    	JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel p1 = new JPanel(new BorderLayout()); // 지역날짜선택 + 물질선택
		JPanel p2 = new JPanel(new BorderLayout()); // 지역선택 + 날짜선택
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 날짜선택
		JPanel p4_1 = new JPanel(new FlowLayout());
		JPanel p5 = new JPanel(new BorderLayout()); // 물질선택
		JPanel p6 = new JPanel(); // 단위 선택 라디오 버튼
		JPanel p7 = new JPanel(new GridLayout(1, 2)); // 물질 선택 박스 모음
		JPanel p7_0 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 물질선택란
		JPanel p7_1 = new JPanel(new BorderLayout());
		JPanel p7_2 = new JPanel(new BorderLayout());
		JPanel ppmPanel = new JPanel(new BorderLayout());
		JPanel μgPanel = new JPanel(new BorderLayout());
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("조회하기");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("수정할 데이터입니다.");
		JLabel l2 = new JLabel("새로운 데이터를 입력하세요.");
		JButton b1 = new JButton("수정");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		E_p2.add(l2);
		E_p2.add(t3);
		E_p2.add(b1);
		E_p3.add(btn);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
		add(Eastpanel, BorderLayout.CENTER);
		
		JLabel lbl1 = new JLabel("날짜 선택");
		JLabel lbl2 = new JLabel("지역 선택");
		JLabel lbl3 = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel lbl4 = new JLabel("물질 선택");
		
		cb.setPreferredSize(new Dimension(200, 25));
		
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
	
		radioBtns.add(ck1);
		radioBtns.add(ck2);
		radioBtns.add(ck3);
		radioBtns.add(ck4);
		radioBtns.add(ck5);
		radioBtns.add(ck6);
	
		ppmPanel.setBorder(new TitledBorder(new EtchedBorder(), " ppm "));
		μgPanel.setBorder(new TitledBorder(new EtchedBorder(), " μg "));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
	
		Westpanel.add(p1);
		
		p1.add(p2, BorderLayout.NORTH);
		p1.add(p5, BorderLayout.CENTER);
	
		p2.add(p3, BorderLayout.NORTH);
		p2.add(p4, BorderLayout.CENTER);
		p3.add(lbl2);
		p3.add(cb);
		p4.add(lbl1);
		p4.add(p4_1);
		p4_1.add(lbl3);
		p4_1.add(t1);
		p4_1.add(month);
		p4_1.add(t2);
		p4_1.add(day);
	
		p5.add(p7_0, BorderLayout.NORTH);
		p5.add(p7, BorderLayout.CENTER);
		p5.add(apply, BorderLayout.SOUTH);
		p7.add(p7_1);
		p7.add(p7_2);
		p7_0.add(lbl4);
		p7_1.add(ppmPanel, BorderLayout.CENTER);
		p7_2.add(μgPanel, BorderLayout.CENTER);
	
		ppmPanel.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
	
		μgPanel.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
	
		add(Westpanel, BorderLayout.WEST);
		
		
    }
 
    class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 1번 호출
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("panel01"); // 뒤로가기 버튼을 누르면 돌아간다.
        }
    }
}

//삭제하기 패널 클래스
@SuppressWarnings("serial")
class Delete extends JPanel { 
	public String[] region = { "강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구", "구로구", "궁동", "금천구",
			"남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구",
			"성동구", "성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구",
			"중랑구", "천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };
	public ButtonGroup radioBtns = new ButtonGroup(); // 물질 중복 선택 방지 위한 라디오 버튼
	public JRadioButton ck1 = new JRadioButton("이산화질소");
	public JRadioButton ck2 = new JRadioButton("일산화산소");
	public JRadioButton ck3 = new JRadioButton("아황산가스");
	public JRadioButton ck4 = new JRadioButton("오존");
	public JRadioButton ck5 = new JRadioButton("미세먼지");
	public JRadioButton ck6 = new JRadioButton("초미세먼지");
	public JButton apply = new JButton("조회");
	public JTextField t3 = new JTextField(10); // 수정할 데이터 입력 영역
	public JTextField t1 = new JTextField(2); // 월 입력
	public JTextField t2 = new JTextField(2); // 일 입력
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	public JButton btn = new JButton("뒤로가기");
	public JPanelTest win;

  public Delete(JPanelTest win) {
      setLayout(null);
      this.win = win;
      setLayout(new BorderLayout(10,10));
      
      showForm();
      
      btn.addActionListener(new MyActionListener());
  }
  
  void showForm() {
  	JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
  	JPanel p1 = new JPanel(new BorderLayout()); // 지역날짜선택 + 물질선택
		JPanel p2 = new JPanel(new BorderLayout()); // 지역선택 + 날짜선택
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 날짜선택
		JPanel p4_1 = new JPanel(new FlowLayout());
		JPanel p5 = new JPanel(new BorderLayout()); // 물질선택
		JPanel p6 = new JPanel(); // 단위 선택 라디오 버튼
		JPanel p7 = new JPanel(new GridLayout(1, 2)); // 물질 선택 박스 모음
		JPanel p7_0 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 물질선택란
		JPanel p7_1 = new JPanel(new BorderLayout());
		JPanel p7_2 = new JPanel(new BorderLayout());
		JPanel ppmPanel = new JPanel(new BorderLayout());
		JPanel μgPanel = new JPanel(new BorderLayout());
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("삭제하기");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("삭제할 데이터입니다.");
		JButton b1 = new JButton("삭제하기");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		E_p2.add(b1);
		E_p3.add(btn);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
		add(Eastpanel, BorderLayout.CENTER);
		
		JLabel lbl1 = new JLabel("날짜 선택");
		JLabel lbl2 = new JLabel("지역 선택");
		JLabel lbl3 = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel lbl4 = new JLabel("물질 선택");
		
		cb.setPreferredSize(new Dimension(200, 25));
		
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
	
		radioBtns.add(ck1);
		radioBtns.add(ck2);
		radioBtns.add(ck3);
		radioBtns.add(ck4);
		radioBtns.add(ck5);
		radioBtns.add(ck6);
	
		ppmPanel.setBorder(new TitledBorder(new EtchedBorder(), " ppm "));
		μgPanel.setBorder(new TitledBorder(new EtchedBorder(), " μg "));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
	
		Westpanel.add(p1);
		
		p1.add(p2, BorderLayout.NORTH);
		p1.add(p5, BorderLayout.CENTER);
	
		p2.add(p3, BorderLayout.NORTH);
		p2.add(p4, BorderLayout.CENTER);
		p3.add(lbl2);
		p3.add(cb);
		p4.add(lbl1);
		p4.add(p4_1);
		p4_1.add(lbl3);
		p4_1.add(t1);
		p4_1.add(month);
		p4_1.add(t2);
		p4_1.add(day);
	
		p5.add(p7_0, BorderLayout.NORTH);
		p5.add(p7, BorderLayout.CENTER);
		p5.add(apply, BorderLayout.SOUTH);
		p7.add(p7_1);
		p7.add(p7_2);
		p7_0.add(lbl4);
		p7_1.add(ppmPanel, BorderLayout.CENTER);
		p7_2.add(μgPanel, BorderLayout.CENTER);
	
		ppmPanel.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
	
		μgPanel.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
	
		add(Westpanel, BorderLayout.WEST);
  }

  class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 1번 호출
      @Override
      public void actionPerformed(ActionEvent e) {
          win.change("panel01"); // 뒤로가기 버튼을 누르면 돌아간다.
      }
  }
}

// 추가하기 패널 클래스
@SuppressWarnings("serial")
class Create extends JFrame{
	public String[] region = { "강남구", "강남대로", "강동구", "강변북로", "강북구", "강서구", "공항대로", "관악구", "관악산", "광진구", "구로구", "궁동", "금천구",
			"남산", "노원구", "도봉구", "도산대로", "동대문구", "동작구", "도산대로", "동대문구", "동작구", "동작대로", "마포구", "북한산", "서대문구", "서초구",
			"성동구", "성북구", "세곡", "송파구", "시흥대로", "신촌로", "양천구", "영등포구", "영등포로", "용산구", "은평구", "정릉로", "종로", "종로구", "중구",
			"중랑구", "천호대로", "청계천로", "한강대로", "행주", "홍릉로", "화랑로" };
	public ButtonGroup radioBtns = new ButtonGroup(); // 물질 중복 선택 방지 위한 라디오 버튼
	public JRadioButton ck1 = new JRadioButton("이산화질소");
	public JRadioButton ck2 = new JRadioButton("일산화산소");
	public JRadioButton ck3 = new JRadioButton("아황산가스");
	public JRadioButton ck4 = new JRadioButton("오존");
	public JRadioButton ck5 = new JRadioButton("미세먼지");
	public JRadioButton ck6 = new JRadioButton("초미세먼지");
	public JButton apply = new JButton("조회");
	public JTextField t3 = new JTextField(10); // 수정할 데이터 입력 영역
	public JTextField t1 = new JTextField(2); // 월 입력
	public JTextField t2 = new JTextField(2); // 일 입력
	public JComboBox<String> cb = new JComboBox<>(region);
	public JTextArea textArea = new JTextArea(1, 10);
	public JButton btn = new JButton("뒤로가기");
	public JPanelTest win;
	
	public Create(JPanelTest win) {
		setLayout(null);
		this.win = win;
		setLayout(new BorderLayout(10,10));
	      
	    showForm();
	      
	    btn.addActionListener(new MyActionListener());
	}
	
	void showForm() {
		JPanel Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel p1 = new JPanel(new BorderLayout()); // 지역날짜선택 + 물질선택
		JPanel p2 = new JPanel(new BorderLayout()); // 지역선택 + 날짜선택
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 지역선택
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 날짜선택
		JPanel p4_1 = new JPanel(new FlowLayout());
		JPanel p5 = new JPanel(new BorderLayout()); // 물질선택
		JPanel p6 = new JPanel(); // 단위 선택 라디오 버튼
		JPanel p7 = new JPanel(new GridLayout(1, 2)); // 물질 선택 박스 모음
		JPanel p7_0 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 물질선택란
		JPanel p7_1 = new JPanel(new BorderLayout());
		JPanel p7_2 = new JPanel(new BorderLayout());
		JPanel ppmPanel = new JPanel(new BorderLayout());
		JPanel μgPanel = new JPanel(new BorderLayout());
		JPanel Northpanel = new JPanel(new GridLayout(1,0));
		Northpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		JPanel Westpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel Eastpanel = new JPanel(new GridLayout(3,1));
		JPanel E_p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel E_p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("조회하기");
		Title.add(title);
		Northpanel.add(Title);
		add(Northpanel, BorderLayout.CENTER);
		
		JLabel l1 = new JLabel("조회한 데이터입니다.");
		textArea.setEditable(false);
		Eastpanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
		E_p1.add(l1);
		E_p1.add(textArea);
		Eastpanel.add(E_p1);
		Eastpanel.add(E_p2);
		Eastpanel.add(E_p3);
		add(Eastpanel, BorderLayout.CENTER);
		
		JLabel lbl1 = new JLabel("날짜 선택");
		JLabel lbl2 = new JLabel("지역 선택");
		JLabel lbl3 = new JLabel("2018년");
		JLabel month = new JLabel("월");
		JLabel day = new JLabel("일");
		JLabel lbl4 = new JLabel("물질 선택");
		
		cb.setPreferredSize(new Dimension(200, 25));
		
		Box ppm = Box.createVerticalBox();
		Box μg = Box.createVerticalBox();
	
		radioBtns.add(ck1);
		radioBtns.add(ck2);
		radioBtns.add(ck3);
		radioBtns.add(ck4);
		radioBtns.add(ck5);
		radioBtns.add(ck6);
	
		ppmPanel.setBorder(new TitledBorder(new EtchedBorder(), " ppm "));
		μgPanel.setBorder(new TitledBorder(new EtchedBorder(), " μg "));
		p1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
	
		Westpanel.add(p1);
		
		p1.add(p2, BorderLayout.NORTH);
		p1.add(p5, BorderLayout.CENTER);
	
		p2.add(p3, BorderLayout.NORTH);
		p2.add(p4, BorderLayout.CENTER);
		p3.add(lbl2);
		p3.add(cb);
		p4.add(lbl1);
		p4.add(p4_1);
		p4_1.add(lbl3);
		p4_1.add(t1);
		p4_1.add(month);
		p4_1.add(t2);
		p4_1.add(day);
	
		p5.add(p7_0, BorderLayout.NORTH);
		p5.add(p7, BorderLayout.CENTER);
		p7.add(p7_1);
		p7.add(p7_2);
		p7_0.add(lbl4);
		p7_1.add(ppmPanel, BorderLayout.CENTER);
		p7_2.add(μgPanel, BorderLayout.CENTER);
	
		ppmPanel.add(ppm, BorderLayout.CENTER);
		ppm.add(Box.createVerticalStrut(15));
		ppm.add(ck1);
		ppm.add(ck2);
		ppm.add(ck3);
		ppm.add(ck4);
	
		μgPanel.add(μg, BorderLayout.CENTER);
		μg.add(Box.createVerticalStrut(15));
		μg.add(ck5);
		μg.add(ck6);
	
		add(Westpanel, BorderLayout.WEST);	
	}
	 
	
	class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 1번 호출
	      @Override
	      public void actionPerformed(ActionEvent e) {
	          win.change("panel01"); // 뒤로가기 버튼을 누르면 돌아간다.
	      }
	}
}

@SuppressWarnings("serial")
class JPanelTest extends JFrame {
 
    public JPanel01 jpanel01 = null;
    public Modify modify = null;
    public Delete delete = null;
    public Create create = null;
    
    public void change(String panelName) { // 패널 1번과 2번 변경 후 재설정
 
        if (panelName.equals("panel01")) {
            getContentPane().removeAll();
            getContentPane().add(jpanel01);
            revalidate();
            repaint();
        } else if(panelName.equals("create")) {
            getContentPane().removeAll();
            getContentPane().add(create);
            revalidate();
            repaint();
        } else if(panelName.equals("delete")) {
            getContentPane().removeAll();
            getContentPane().add(delete);
            revalidate();
            repaint();
        } else if(panelName.equals("modify")){
            getContentPane().removeAll();
            getContentPane().add(modify);
            revalidate();
            repaint();
        } 
    }
 
}

public class PanelChangeExample extends JFrame{
	// 생성자
	PanelChangeExample() {
		JPanelTest win = new JPanelTest();
		
        win.setTitle("고갱이");
        setLayout(new BorderLayout(10,10));
        win.jpanel01 = new JPanel01(win); 
        win.create = new Create(win); // 추가하기 패널
        win.modify = new Modify(win); // 수정하기 패널
        win.delete = new Delete(win); // 삭제하기 패널
        
        win.add(win.jpanel01);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(800, 500);
        win.setVisible(true);
	}
	
   
}