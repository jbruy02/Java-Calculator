import java.util.Scanner;

public class Calculator {
	public static double result;
	
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		double nextOperand;
		char nextOperator;
		String input = "";
		boolean again = true;
		boolean firstRun = true;
		
		try{
			System.out.println("Calculator is on");
			while(again){
				if(firstRun){
					result = 0;
					System.out.println("result = " + result);
					input = keyboard.next();
					nextOperator = input.charAt(0);
					nextOperand = Double.parseDouble(input.substring(1));
					calculate(nextOperator, nextOperand);
					System.out.println("result " + nextOperator + " " + nextOperand + " = " + result);
					System.out.println("new result = " + result);
				}
				input = keyboard.next();	
				while (!input.equalsIgnoreCase("R")){	
					nextOperator = input.charAt(0);
					nextOperand = Double.parseDouble(input.substring(1));
					calculate(nextOperator, nextOperand);
					System.out.println("result " + nextOperator + " " + nextOperand + " = " + result);
					System.out.println("updated result = " + result);
					input = keyboard.next();
				}
				System.out.println("Final result = " + result);
				System.out.println("Again? (y/n)");
				input = keyboard.next();
				if (input.substring(0, 1).equalsIgnoreCase("y")){
					again = true;
					firstRun = true;
				}
					if (input.substring(0, 1).equalsIgnoreCase("n"))
						again = false;
				}
			System.out.println("End of program."); 
			System.exit(0);
		}
		catch(DivideByZeroException e){
			System.out.println(e.getMessage());
			secondChance( );
		}
		catch(UnknownOperatorException o){
			System.out.println(o.getBadOperation() + " is an unknown operation.");
			secondChance( );
		}
	}
	
	public static double calculate(char operator, double operand) throws DivideByZeroException,
		UnknownOperatorException{
		
		if (operator == '/' || operator == '+' || operator == '-'
			|| operator == '*') {
			
				if (operator == '/'){
					if (operand == 0)
						throw (new DivideByZeroException());
					result /= operand;
				}
				
				if (operator == '+')
					result += operand;
			
				if (operator == '-')
					result -= operand;
				
				if (operator == '*')
					result *= operand;
		}
		
		else
			throw (new UnknownOperatorException(operator));
		
		return result;
	}
	
	public static void secondChance(){
		Scanner keyboard = new Scanner(System.in);
		double nextOperand;
		char nextOperator;
		String input = "";
		boolean again = true;
		boolean firstRun = false;
		
		try{
			System.out.println("Reenter your last line:");
			while(again){
				if(firstRun){
					result = 0;
					System.out.println("result = " + result);
					input = keyboard.next();
					nextOperator = input.charAt(0);
					nextOperand = Double.parseDouble(input.substring(1));
					calculate(nextOperator, nextOperand);
					System.out.println("result " + nextOperator + " " + nextOperand + " = " + result);
					System.out.println("new result = " + result);
				}
				input = keyboard.next();	
				while (!input.equalsIgnoreCase("R")){	
					nextOperator = input.charAt(0);
					nextOperand = Double.parseDouble(input.substring(1));
					calculate(nextOperator, nextOperand);
					System.out.println("result " + nextOperator + " " + nextOperand + " = " + result);
					System.out.println("updated result = " + result);
					input = keyboard.next();
				}
				System.out.println("Final result = " + result);
				System.out.println("Again? (y/n)");
				input = keyboard.next();
				if (input.substring(0, 1).equalsIgnoreCase("y")){
					again = true;
					firstRun = true;
				}
				if (input.substring(0, 1).equalsIgnoreCase("n"))
					again = false;
			}
			System.out.println("End of program."); 
			System.exit(0);
		}
		catch(DivideByZeroException e){
			System.out.println("Cannot divide by zero."); 
			System.out.println("Aborting program."); 
			System.exit(0);
		}
		catch(UnknownOperatorException o){
			System.out.println("I don't understand this operator.");
			System.out.println("Aborting program."); 
			System.exit(0);		}
	}
}
