package linked_list.exceptions;

public class ElementNotFoundException extends Exception{
	private static final long serialVersionUID = 8457234685109L;

	@Override
	public String getMessage() {
		System.out.println("Key element not found in Linked List!!");
		return super.getMessage();
	}
}
