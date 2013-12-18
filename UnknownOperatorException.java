
public class UnknownOperatorException extends Exception {
	private char badOperation;
	
	public UnknownOperatorException(char operation){
		super("Unknown operator!");
		badOperation = operation;
	}
	
	public UnknownOperatorException(){
		super("Unknown operator!");
	}
	
	public UnknownOperatorException(String message) {
		super(message);
		}
	
	public char getBadOperation(){
		return badOperation;
	}
}
