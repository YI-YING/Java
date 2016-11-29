import java.util.*;
class CStack <T> {
    private T [] data;
    private int dataPtr;
    
    public CStack () {
        this(20);
    }
    public CStack (int size) {
        data = (T[])new Object[size];
        dataPtr = 0;
    }
    public void Push(T ob) {
        data[dataPtr] = ob;
        dataPtr++;
    }
    
    public T Pop() {
        dataPtr--;
        return data[dataPtr];
    }
    
    public T Peek() {
        return data[dataPtr -1];
    }
    
    public boolean Empty() {
        if (dataPtr == 0)
            return true;
        else
            return false;
    }
}
public class HW11_05366016_V5 {
    
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
        
        CStack <Character> operatorStack = new CStack();
        CStack <Double> operandStack = new CStack();
        
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
