package queue.linked;

import queue.exceptions.ElementNotFoundException;
import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class LinkedQueue {

	Node front, rear;
	int capacity;
	int size;

	LinkedQueue(int capacity){
		front = rear = null;
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return this.capacity;
	}

	public int getSize() {
		return this.size;
	}

	// insert at rear end
	void enque(int data) throws QueueOverflowException {
		Node qNode = new Node(data);
		if(size == capacity)
			throw new QueueOverflowException();
		else if(isEmpty()) 
			front = rear = qNode;
		else {
			rear.next = qNode;
			rear = qNode;
			size++;
		}	
	}

	// remove from front end
	int deque() throws QueueUnderflowException {
		int deleted = 0;
		if(isEmpty())
			throw new QueueUnderflowException();
		else {
			deleted = front.data;
			front = front.next;
			size--;
		}
		return deleted;
	}

	void display() throws QueueUnderflowException {

		System.out.println("\nDisplaying Queue : \n");
		if(isEmpty())
			throw new QueueUnderflowException();
		Node temp = front;
		while(temp != null) {
			System.out.print(" "+temp.data);
			temp = temp.next;
		}

	}

	void destroy() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException();
		while(front != null)
			deque();
	}

	int search(int key) throws QueueUnderflowException, ElementNotFoundException {

		if(isEmpty())
			throw new QueueUnderflowException();
		int index = -1;
		Node temp = front;
		while(temp != null) {
			index++;
			if(temp.data == key) {
				return index;
			}
			temp = temp.next;
		}
		if(index == size-1)
			throw new ElementNotFoundException();
		return index;
	}

	boolean isEmpty() {
		return size == 0;
	}
}
