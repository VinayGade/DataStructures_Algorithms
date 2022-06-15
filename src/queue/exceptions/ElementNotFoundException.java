package queue.exceptions;

public class ElementNotFoundException extends Exception{

	private static final long serialVersionUID = 9130053761049239859L;

	@Override
	public String getMessage() {
		System.out.println("Element not present in Queue !!");
		return super.getMessage();
	}
}
