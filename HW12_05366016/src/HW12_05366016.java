import java.util.*;
class CStack <T>
{
	private T data[];
	private int dataPtr;
	
	public CStack()
	{
		data = (T[])new Object[20];
		dataPtr = 0;
	}
	
	public void push(T num)
	{
		data[dataPtr] = num;
		dataPtr++;
	}

	public T pop()
	{
		dataPtr--;
		return data[dataPtr];
	}
	
	public T peek()
	{
		return data[dataPtr-1];
	}
		
	public boolean empty()
	{
		if(dataPtr == 0)
			return true;
		else
			return false;
	}
}

public class HW12_05366016 {
	public static int precedence(char c)
	{
		switch(c)
		{
			case '+':
			case '-': return 4;
			case '*':
			case '/': return 5;
		}
		
		return 0;
	}
	
	public static CFraction calculate(CFraction num1, CFraction num2, char operator)
	{
		switch(operator)
		{
			case '+':
				return num1.add(num2);
			case '-':
				return num1.sub(num2);
			case '*':
				return num1.mul(num2);
			case '/':
				return num1.div(num2);
		}
		
		return new CFraction(0,1);
	}
	
	public static void main(String[] args)
	{
		CFraction num, num1, num2;
		char   operator;
		
		CStack <CFraction>    operandStack  = new CStack<CFraction>();
		CStack <Character> operatorStack = new CStack<Character>();
						
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your expression: ");
		
		num = new CFraction(input.nextInt(),input.nextInt());
		operator = input.next().charAt(0);
		
		while(operator != '=')
		{
			operandStack.push(num);
			
			if(operatorStack.empty())
				operatorStack.push(operator);
			else
			{
				while(precedence(operatorStack.peek()) >= precedence(operator))
				{
					num2 = operandStack.pop();
					num1 = operandStack.pop();
					num = calculate(num1, num2, operatorStack.pop());
					operandStack.push(num);
					
					if(operatorStack.empty())
						break;
				}
				
				operatorStack.push(operator);
			}
			
			num = new CFraction(input.nextInt(),input.nextInt());
			operator = input.next().charAt(0);
		}
		
		operandStack.push(num);
		
		while(!operatorStack.empty())
		{
			num2 = operandStack.pop();
			num1 = operandStack.pop();
			num  = calculate(num1, num2, operatorStack.pop());
			operandStack.push(num);
		}
					
		System.out.println(operandStack.pop());
	}
    
}
