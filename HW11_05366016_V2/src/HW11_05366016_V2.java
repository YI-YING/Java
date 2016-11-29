import java.util.*;
class COperandStack {
    public double [] operandStack = new double[20];
    public int operandStackPtr = 0;

    public void Push(double num) {
        operandStack[operandStackPtr] = num;
        operandStackPtr++;
    }
    
    public double Pop() {
        operandStackPtr--;
        return operandStack[operandStackPtr];
    }
    
    public double Peek() {
        return operandStack[operandStackPtr -1];
    }
    
    public boolean Empty() {
        if (operandStackPtr == 0)
            return true;
        else
            return false;
    }
}
class COperatorStack {
    public char [] operatorStack = new char[20];
    public int operatorStackPtr = 0;
    
    public void Push(char op) {
        operatorStack[operatorStackPtr] = op;
        operatorStackPtr++;
    }

    public char Pop() {
        operatorStackPtr--;
        return operatorStack[operatorStackPtr];
    }
    
    public char Peek() {
        return operatorStack[operatorStackPtr -1];
    }
    
    public boolean Empty() {
        if (operatorStackPtr == 0)
            return true;
        else
            return false;
    }
    
}
public class HW11_05366016_V2 {
    
    
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
        
        COperatorStack operatorStack = new COperatorStack();
        COperandStack operandStack = new COperandStack();
        
        num = sc.nextDouble();
        operator = sc.next().charAt(0);
        
        while (operator != '=') {
            operandStack.Push(num);
            
            if (operatorStack.Empty())
                operatorStack.Push(operator);
            else {
                while (precedence(operatorStack.Peek()) > precedence(operator)) {
                    num2 = operandStack.Pop();
                    num1 = operandStack.Pop();
                    num = calculate(num1, num2, operatorStack.Pop());
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
            num2 = operandStack.Pop();
            num1 = operandStack.Pop();
            num = calculate(num1, num2, operatorStack.Pop());
            
            operandStack.Push(num);
        }
        
        
        System.out.println(operandStack.Pop());
    }
    
}
