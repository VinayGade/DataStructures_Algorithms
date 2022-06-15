package stack.exceptions;

public class StackUnderflowException extends Exception{

	private static final long serialVersionUID = 9454634685134L;

	@Override
	public String getMessage() {
		System.out.println("EmptyStackException : Since stack is empty data to be popped out from stack cannot be found !");
		return super.getMessage();
	}
}