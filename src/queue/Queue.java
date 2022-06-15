package queue;

import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class Queue {
	
	private int queue[];
	private int front, rear, size, capacity;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = rear = -1;
	}
	
	boolean isEmpty() {
		return (front == -1 || front > rear);
	}
	
	public void enque(int data) throws QueueOverflowException {
		if(rear == capacity-1)
			throw new QueueOverflowException();
		
		rear++;
		queue[rear]=data;
		
		if(front == -1)
			front++;
		
		size++;
	}
	
	public int deque() throws QueueUnderflowException{
		if(isEmpty())
			throw new QueueUnderflowException();
		int removed = queue[front];
		front++;
		size--;
		return removed;
	}
	
	public void traverse() throws QueueUnderflowException{
		if(isEmpty())
			throw new QueueUnderflowException();
		System.out.println("Display Queue : ");
		for(int i=front; i<=rear; i++)
			System.out.print(" "+queue[i]);
	}
	
	public int search(int key) throws QueueUnderflowException{
		if(isEmpty())
			throw new QueueUnderflowException();
		int index = -1;
		for(int i=front; i<=rear; i++) {
			if(queue[i] == key) {
				index = i;
				break;
			}
		}
		return index;
	}
}
