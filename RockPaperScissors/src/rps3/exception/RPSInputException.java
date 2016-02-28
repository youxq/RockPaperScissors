package rps3.exception;

public class RPSInputException extends Exception{
	public RPSInputException() {
		super("Input does not match the request. Try again");
	}
}
