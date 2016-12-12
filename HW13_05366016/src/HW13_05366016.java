import java.awt.*;
import java.awt.event.*;

public class HW13_05366016 {
    
    public static void main(String[] args) {
        Frame frm = new Frame("Hello world!");
        Label lab = new Label("First Java Frame program");
        TextField tx1 = new TextField("Ha Ha");
        TextField tx2 = new TextField("Name");
        TextField tx3 = new TextField("Passward");
        Button btn = new Button("Login");
        TextArea txa = new TextArea("This website is created by God YI.\r\nHope you would love it!", 8, 14, TextArea.SCROLLBARS_VERTICAL_ONLY);
        
        frm.setLayout(null);
        frm.setSize(600, 400);
        frm.setBackground(Color.CYAN);
        frm.setLocation(250, 250);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        lab.setBackground(Color.white);
        lab.setAlignment(Label.CENTER);
        lab.setForeground(Color.blue);
        lab.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
        lab.setBounds(20, 40, 560, 20);
        
        tx1.setBounds(20, 70, 120, 20);
        tx2.setBounds(20, 100, 120, 20);
        tx3.setBounds(20, 130, 120, 20);
        
        tx1.setEditable(false);
        tx3.setEchoChar('*');
        
        btn.setBounds(150, 65, 100, 90);
        
        txa.setBounds(20, 170, 230, 80);
        
        frm.add(lab);
        frm.add(tx1);
        frm.add(tx2);
        frm.add(tx3);
        frm.add(btn);
        frm.add(txa);
        
        frm.setVisible(true);
    }
    
}
