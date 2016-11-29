import java.util.*;
class CStack {
    public String [] data;
    public int operandStackPtr;
    
    public CStack () {
        data = new String[20];
        operandStackPtr = 0;
    }
    public void Push(char op) {
        data[operandStackPtr] = String.valueOf(op);
        operandStackPtr++;
    }
    public void Push(double num) {
        data[operandStackPtr] = String.valueOf(num);
        operandStackPtr++;
    }
    
    public String Pop() {
        operandStackPtr--;
        return data[operandStackPtr];
    }
    
    public String Peek() {
        return data[operandStackPtr -1];
    }
    
    public boolean Empty() {
        if (operandStackPtr == 0)
            return true;
        else
            return false;
    }
}
public class HW11_05366016_V3 {
    
    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-': return 4;
            case '*':
            case '/': return 5;
        }
        return 0;
    }
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+' : return num1 + num2; 
            case '-' : return num1 - num2; 
            case '*' : return num1 * num2;
            case '/' : return num1 / num2;
        }
        return 0.0;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num, num1, num2;
        char operator;
        
        System.out.println("Please enter your expression:");
        
        CStack operatorStack = new CStack();
        CStack operandStack = new CStack();
        
        num = sc.nextDouble();
        operator = sc.next().charAt(0);
        
        while (operator != '=') {
            operandStack.Push(num);
            
            if (operatorStack.Empty())
                operatorStack.Push(operator);
            else {
                while (precedence(operatorStack.Peek().charAt(0)) > precedence(operator)) {
                    num2 = Double.valueOf(operandStack.Pop());
                    num1 = Double.valueOf(operandStack.Pop());
                    num = calculate(num1, num2, operatorStack.Pop().charAt(0));
                    operandStack.Push(num);
                    
                    if (operatorStack.Empty())
                        break;
                }
                operatorStack.Push(operator);
            }
            num = sc.nextDouble();
            operator = sc.next().charAt(0);
        }
        operandStack.Push(num);
        
        while (!operatorStack.Empty()) {
            num2 = Double.valueOf(operandStack.Pop());
            num1 = Double.valueOf(operandStack.Pop());
            num = calculate(num1, num2, operatorStack.Pop().charAt(0));
            
            operandStack.Push(num);
        }
        
        
        System.out.println(operandStack.Pop());
    }
    
}
