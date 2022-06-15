package stack;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

class StackNode {

	int data;
	StackNode next;

	StackNode(int data){
		this.data = data;
	}
}

public class LinkedStack implements StackADT{

	StackNode top;
	int capacity;

	LinkedStack() {
		top = null;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public StackNode getTop() {
		return top;
	}

	public void setTop(StackNode top) {
		this.top = top;
	}

	@Override
	public void push(int x) throws StackOverflowException {

		StackNode node = new StackNode(x);
		if(size() == getCapacity())
			throw new StackOverflowException();
		else if(top == null)     //Stack empty
			node.next = null;
		else
			node.next = top;
		top = node;              // new node appears on top of stack

	}

	@Override
	public int pop() throws StackUnderflowException {
		int poppedElement = 0;
		if(size() == 0)
			throw new StackUnderflowException();
		else {
			poppedElement = top.data;
			top = top.next;
		}
		return poppedElement;
	}

	@Override
	public int peek() throws StackUnderflowException {
		int tos = 0;
		if(size() == 0)
			throw new StackUnderflowException();
		else
			tos = top.data;
		return tos;
	}

	@Override
	public void display() {

		StackNode temp = top;
		if(temp == null)
			return;
		while(temp.next != null) {
			System.out.print(temp.data+ " ");
			temp = temp.next;
		}
		System.out.print(temp.data); //top of stack
	}

	@Override
	public void destroy() throws StackUnderflowException {
		while(top != null)
			pop();
	}

	@Override
	public boolean isEmpty() {	
		return top == null;
	}

	@Override
	public int size() {

		int n = 0;

		if(top != null){	
			
			StackNode temp = top;
			while(temp.next!= null) {
				n++;
				temp=temp.next;
			}	
		}
		return n;
	}

}
