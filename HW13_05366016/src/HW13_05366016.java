import java.awt.*;
import java.awt.event.*;

public class HW13_05366016 {
    
    public static void main(String[] args) {
        Frame frm = new Frame("Hello world!");
        BorderLayout border = new BorderLayout(2, 5);

        Label lab = new Label("First Java Frame program");
        Label labInput = new Label("Please enter a num :");

        TextField tx1 = new TextField("Ha Ha");

        Button btn = new Button("Run");

        TextArea txa = new TextArea("This website is created by God YI.\r\nHope you would love it!", 8, 14, TextArea.SCROLLBARS_VERTICAL_ONLY);
        
        frm.setLayout(border);
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
        //lab.setBounds(20, 40, 560, 20);
        //labInput.setBounds(20, 70, 120, 20);
        
        //tx1.setBounds(150, 70, 120, 20);
        
        tx1.setEditable(false);
        
        //btn.setBounds(280, 65, 100, 90);
        
        //txa.setBounds(150, 170, 230, 80);
        
        frm.add(lab, BorderLayout.NORTH);
        frm.add(labInput, BorderLayout.WEST);
        frm.add(tx1, BorderLayout.CENTER);
        frm.add(btn, BorderLayout.EAST);
        frm.add(txa, BorderLayout.SOUTH);
        
        frm.setVisible(true);
    }
    
}
