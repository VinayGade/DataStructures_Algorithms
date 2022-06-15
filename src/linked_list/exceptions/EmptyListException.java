package linked_list.exceptions;

public class EmptyListException extends Exception{
	private static final long serialVersionUID = 9454234685107L;

	@Override
	public String getMessage() {
		System.out.println("Linked List empty !!");
		return super.getMessage();
	}
}
