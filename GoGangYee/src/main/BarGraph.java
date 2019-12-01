package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BarGraph extends JPanel{   //막대 그래프 그려주는 함수이다.
	   //BarGraph(데이터 값이 들어있는 배열, X축에 써줄 문자열 배열, 그래프 너비, 그래프 간격, 데이터에 곱하여 정수로 만들어줄 변수)
	   //사용 예시
	   //BarGraph graph=new BarGraph(data,label,50,20,1000);
	   //add(graph);
	   
	   private int barWidth;   //그래프 너비
	   private int barGap;      //그래프 간격
	   
	    private List<Bar> bars = new ArrayList<Bar>();   //막대 리스트
	    
	    private int mul;   //정수 만들어주는애
	   
	    public BarGraph(double[] data, String[] labels, int width, int gap, int mul) {
	        Color[] c= {Color.RED, Color.YELLOW, Color.BLUE, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.GREEN, Color.PINK};   //색 순서
	       
	       for(int i=0;i<data.length;i++)   //bars에 추가
	          addBar(labels[i],data[i],c[i]);
	       this.barWidth=width;
	       this.barGap=gap;
	       this.mul=mul;
	    }
	    
	    public void addBar(String label, double value, Color color) {
	      Bar b=new Bar(label, value, color);
	      bars.add(b);   //막대 리스트에 추가
	   }
	    
	    public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       int count=0;
	       int val;
	       
	      g.drawLine(30, this.getHeight()-30, this.getWidth()-30, this.getHeight()-30);   //X축 그리기
	      g.drawLine(30, this.getHeight()-30, 30, 30);   //Y축 그리기

	       
	       for(Bar b:this.bars) {
	          g.setColor(b.getColor());
	          val=(int)(b.getValue()*this.mul);
	          System.out.println("곱 = "+val);
	          g.fillRect(50+count*(barWidth+barGap), this.getHeight()-(val)-30,barWidth, val);   //그래프 그리기
	          g.setColor(Color.BLACK);
	          
	          g.drawString(Double.toString(b.getValue()), 50+count*(barWidth+barGap)+10, this.getHeight()-(val)-30-20);   //그래프 위에 숫자
	          g.drawString(b.getLabel(), 50+count*(barWidth+barGap)+5, this.getHeight()-5);
	          
	          System.out.println(b.getLabel()+" "+b.getValue()+" "+b.getColor());
	          count++;

	       }
	       setBackground(Color.WHITE);
	    }
	   
	   class Bar{   //하나의 막대 그래프 클래스
	      private String label;
	      private double value;
	      private Color color;
	      
	      public Bar(String label, double value, Color color) {
	         this.label=label;
	         this.value=value;
	         this.color=color;
	      }
	      
	      public String getLabel() {
	         return this.label;
	      }
	      
	      public double getValue() {
	         return this.value;
	      }
	      
	      public Color getColor() {
	         return this.color;
	      }
	   }
	}