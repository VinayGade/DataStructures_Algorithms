package queue.exceptions;

public class QueueUnderflowException extends Exception{

	private static final long serialVersionUID = -1439489144784435819L;

	@Override
	public String getMessage() {
		System.out.println("Queue Underflow. Queue is empty !!");
		return super.getMessage();
	}
}
