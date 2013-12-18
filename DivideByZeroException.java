
public class DivideByZeroException extends Exception {
	public DivideByZeroException(){
		super("Division by zero!!");
	}
	
	public DivideByZeroException(String message){
		super(message);
	}
}
