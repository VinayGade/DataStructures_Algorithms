package queue;

import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class CircularQ {

	private int queue[];
	private int front, rear, size, capacity;
	
	public CircularQ(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = rear = -1;
	}
	
	boolean isEmpty() {
		return (front == -1 || front > rear);
	}
	
	public void enque(int data) throws QueueOverflowException {
		if(front == 0 && rear == capacity-1 || (front == rear+1))
			throw new QueueOverflowException();
		
		rear++;
		if(rear == capacity)
			rear = 0;
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
		if(front == rear+1)
			front=rear=-1;
		if(front == capacity)
			front = 0;
		return removed;
	}
	
	public void traverse() throws QueueUnderflowException{
		if(isEmpty())
			throw new QueueUnderflowException();
		
		System.out.println("Display Queue : ");
		int i=front;
		while(true) {
			System.out.print(" "+queue[i]);
			i++;
			if(i == rear+1)
				break;
			if(i == capacity)
				i=0;
		}
	}
	
	public int search(int key) throws QueueUnderflowException{
		if(isEmpty())
			throw new QueueUnderflowException();
		int index = -1;
		int i=front;
		while(true) {
			if(queue[i] == key) {
				index = i;
				break;
			}
			i++;
			if(i == rear+1)
				break;
			if(i == capacity)
				i=0;
		}
		return index;
	}
}
