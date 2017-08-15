import java.awt.*;

public class HW14_05366016 {
    static Frame frm = new Frame();
    static Panel pnl = new Panel(new GridLayout(4, 4));
    static Label lab = new Label("0", Label.RIGHT);
    
    public static void main(String[] args) {
        frm.setBounds(0, 0, 360, 480);
        frm.setLayout(new BorderLayout());
        
        lab.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 28));
        lab.setBackground(Color.orange);
        lab.setPreferredSize(new Dimension(360, 50));
        
        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnPlus = new Button("+");
        Button btnSub = new Button("-");
        Button btnMulti = new Button("*");
        Button btnDivi = new Button("/");
        Button btnEqual = new Button("=");
        Button btnC = new Button("C");

        pnl.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
        pnl.setPreferredSize(new Dimension(360,430));
        pnl.add(btn7);
        pnl.add(btn8);
        pnl.add(btn9);
        pnl.add(btnPlus);

        pnl.add(btn4);
        pnl.add(btn5);
        pnl.add(btn6);
        pnl.add(btnSub);

        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);
        pnl.add(btnMulti);

        pnl.add(btnC);
        pnl.add(btn0);
        pnl.add(btnEqual);
        pnl.add(btnDivi);
        
        frm.add(lab, BorderLayout.NORTH);
        frm.add(pnl, BorderLayout.CENTER);
        frm.setVisible(true);
    }
    
}
