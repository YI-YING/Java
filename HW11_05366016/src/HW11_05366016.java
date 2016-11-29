import java.util.*;

public class HW11_05366016 {
    public static double [] operandStack = new double[20];
    public static char [] operatorStack = new char[20];
    
    public static int operandStackPtr = 0, operatorStackPtr = 0;
    
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
    
    public static void operandStackPush(double num) {
        operandStack[operandStackPtr] = num;
        operandStackPtr++;
    }
    
    public static double operandStackPop() {
        operandStackPtr--;
        return operandStack[operandStackPtr];
    }
    
    public static double operandStackPeek() {
        return operandStack[operandStackPtr -1];
    }
    
    public static boolean operandStackEmpty() {
        if (operandStackPtr == 0)
            return true;
        else
            return false;
    }
    public static void operatorStackPush(char op) {
        operatorStack[operatorStackPtr] = op;
        operatorStackPtr++;
    }

    public static char operatorStackPop() {
        operatorStackPtr--;
        return operatorStack[operatorStackPtr];
    }
    
    public static char operatorStackPeek() {
        return operatorStack[operatorStackPtr -1];
    }
    
    public static boolean operatorStackEmpty() {
        if (operatorStackPtr == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        double num, num1, num2;
        char operator;

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter your expression:");
        
        num = sc.nextDouble();
        operator = sc.next().charAt(0);
        
        while (operator != '=') {
            operandStackPush(num);
            
            if (operatorStackEmpty())
                operatorStackPush(operator);
            else {
                while (precedence(operatorStackPeek()) > precedence(operator)) {
                    num2 = operandStackPop();
                    num1 = operandStackPop();
                    num = calculate(num1, num2, operatorStackPop());
                    operandStackPush(num);
                    
                    if (operatorStackEmpty())
                        break;
                }
                operatorStackPush(operator);
            }
            num = sc.nextDouble();
            operator = sc.next().charAt(0);
        }
        operandStackPush(num);
        
        while (!operatorStackEmpty()) {
            num2 = operandStackPop();
            num1 = operandStackPop();
            num = calculate(num1, num2, operatorStackPop());
            
            operandStackPush(num);
        }
        
        
        System.out.println(operandStackPop());
    }
    
}
