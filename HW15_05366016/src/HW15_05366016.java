import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import org.rosuda.JRI.Rengine;

public class HW15_05366016 extends JFrame implements ActionListener
{
   static HW15_05366016 frm = new HW15_05366016();
   static Container cp = frm.getContentPane();
   
   static JLabel lab1 = new JLabel("資料筆數：");
   static JLabel lab2 = new JLabel("平均值：");
   static JLabel lab3 = new JLabel("標準差：");
   static JLabel lab5 = new JLabel();

   static JTextField txf1 = new JTextField("100",10);
   static JTextField txf2 = new JTextField("10",10);
   static JTextField txf3 = new JTextField("0.5",10);

   static JButton btn1 = new JButton("清除");
   static JButton btn2 = new JButton("產生");

   static JTable left;   
   static ImageIcon right;  
   
   static JTextArea txa = new JTextArea(10,10);
   static JScrollPane jsp = new JScrollPane(txa);
   
   static Rengine engine = new Rengine(new String[] { "--no-save" }, false, null);
   
   public static void main(String args[])
   {
       Panel pn1 = new Panel(new GridLayout(2,4));
       pn1.add(lab1);
       pn1.add(txf1);
       pn1.add(btn1);
       pn1.add(btn2);
       pn1.add(lab2);
       pn1.add(txf2);
       pn1.add(lab3);
       pn1.add(txf3);
   	
   	   btn1.addActionListener(frm);
   	   btn2.addActionListener(frm);
   	
   	   BorderLayout border = new BorderLayout(0,0);
       cp.setLayout(border);
       
       cp.add(pn1,border.NORTH);
       
       String [] colName = {"統計", "值"};
       Object [][] data = { {"min"        , new Double(0.0)},
       	                    {"Q1 "        , new Double(0.0)},
       	                    {"mean"       , new Double(0.0)},
       	                    {"median"     , new Double(0.0)},
       	                    {"Q3"         , new Double(0.0)},
       	                    {"max"        , new Double(0.0)},
       	                    {"stdev"      , new Double(0.0)} };
       left = new JTable(data, colName);
       
       DefaultTableCellRenderer render = new DefaultTableCellRenderer();
       render.setHorizontalAlignment(SwingConstants.CENTER);
       left.getColumn("統計").setCellRenderer(render);
       left.getColumn("值").setCellRenderer(render);
       
       cp.add(new JScrollPane(left),border.WEST);
       
       lab5.setHorizontalTextPosition(JLabel.CENTER); // 設定文字水平位置
       lab5.setVerticalTextPosition(JLabel.BOTTOM); // 設定文字垂直位置
       cp.add(lab5,border.EAST);
       
       jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       txa.setLineWrap(true);
       txa.setWrapStyleWord(true);
       txa.setFont(new Font("Courier New", Font.PLAIN, 16));
       cp.add(jsp,border.SOUTH);

       frm.setBounds(500,150,995,780);
       frm.setVisible(true);
       
       frm.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent e){
       		System.exit(0);}});
   }
 
   public void actionPerformed(ActionEvent e)
   {
     JButton btn=(JButton) e.getSource(); // 取得被按下的按鈕
        
     if(btn==btn1)
     {
	    txf1.setText("");
	    txf2.setText("");
	    txf3.setText("");
     }
     else if(btn==btn2)
     {
	    double [] y = engine.eval("y = rnorm(" + txf1.getText() + "," + 
	    	                      txf2.getText() + "," + 
	    	                      txf3.getText() + ")").asDoubleArray();
	    txa.setText("");
	    
	    String s = "";
	    
	    for(int i = 0; i < y.length; i++)
	    	s += String.format("%06.2f  ",y[i]);
	    	
	    txa.setText(s);
	    
	    engine.eval("png(file=\"C:/Users/MCU/Desktop/hist.png\")");
	    engine.eval("hist(y, border=\"blue\", col=\"green\", prob=TRUE)");
	    engine.eval("lines(density(y))");
	    engine.eval("dev.off()");
	    
	    try 
	    {
		    FileInputStream fi = new FileInputStream("C:/Users/MCU/Desktop/hist.png");
		    byte [] data = new byte[fi.available()];
		    fi.read(data);
		    lab5.setIcon(new ImageIcon(data));
	    }
	    catch(FileNotFoundException exp) {}
	    catch(IOException exp) {}
	    
	    left.setValueAt(String.format("%07.3f",engine.eval("min(y)").asDouble()),0,1);
	    left.setValueAt(String.format("%07.3f",engine.eval("quantile(y,0.25)").asDouble()),1,1);
	    left.setValueAt(String.format("%07.3f",engine.eval("mean(y)").asDouble()),2,1);
	    left.setValueAt(String.format("%07.3f",engine.eval("median(y)").asDouble()),3,1);
	    left.setValueAt(String.format("%07.3f",engine.eval("quantile(y,0.75)").asDouble()),4,1);
	    left.setValueAt(String.format("%07.3f",engine.eval("max(y)").asDouble()),5,1);
	    left.setValueAt(String.format("%07.3f",engine.eval("sd(y)").asDouble()),6,1);

     }
   }
}