package queue.exceptions;

public class QueueOverflowException extends Exception{

	private static final long serialVersionUID = -3684324837551054796L;

	@Override
	public String getMessage() {
		System.out.println("Queue Overflow. Queue is full. Cannot insert element(s) !!");
		return super.getMessage();
	}

}
