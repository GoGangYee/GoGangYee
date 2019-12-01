package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BarGraph extends JPanel{   //���� �׷��� �׷��ִ� �Լ��̴�.
	   //BarGraph(������ ���� ����ִ� �迭, X�࿡ ���� ���ڿ� �迭, �׷��� �ʺ�, �׷��� ����, �����Ϳ� ���Ͽ� ������ ������� ����)
	   //��� ����
	   //BarGraph graph=new BarGraph(data,label,50,20,1000);
	   //add(graph);
	   
	   private int barWidth;   //�׷��� �ʺ�
	   private int barGap;      //�׷��� ����
	   
	    private List<Bar> bars = new ArrayList<Bar>();   //���� ����Ʈ
	    
	    private int mul;   //���� ������ִ¾�
	   
	    public BarGraph(double[] data, String[] labels, int width, int gap, int mul) {
	        Color[] c= {Color.RED, Color.YELLOW, Color.BLUE, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.GREEN, Color.PINK};   //�� ����
	       
	       for(int i=0;i<data.length;i++)   //bars�� �߰�
	          addBar(labels[i],data[i],c[i]);
	       this.barWidth=width;
	       this.barGap=gap;
	       this.mul=mul;
	    }
	    
	    public void addBar(String label, double value, Color color) {
	      Bar b=new Bar(label, value, color);
	      bars.add(b);   //���� ����Ʈ�� �߰�
	   }
	    
	    public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       int count=0;
	       int val;
	       
	      g.drawLine(30, this.getHeight()-30, this.getWidth()-30, this.getHeight()-30);   //X�� �׸���
	      g.drawLine(30, this.getHeight()-30, 30, 30);   //Y�� �׸���

	       
	       for(Bar b:this.bars) {
	          g.setColor(b.getColor());
	          val=(int)(b.getValue()*this.mul);
	          System.out.println("�� = "+val);
	          g.fillRect(50+count*(barWidth+barGap), this.getHeight()-(val)-30,barWidth, val);   //�׷��� �׸���
	          g.setColor(Color.BLACK);
	          
	          g.drawString(Double.toString(b.getValue()), 50+count*(barWidth+barGap)+10, this.getHeight()-(val)-30-20);   //�׷��� ���� ����
	          g.drawString(b.getLabel(), 50+count*(barWidth+barGap)+5, this.getHeight()-5);
	          
	          System.out.println(b.getLabel()+" "+b.getValue()+" "+b.getColor());
	          count++;

	       }
	       setBackground(Color.WHITE);
	    }
	   
	   class Bar{   //�ϳ��� ���� �׷��� Ŭ����
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