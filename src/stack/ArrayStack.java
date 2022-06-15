package stack;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

public class ArrayStack implements StackADT{

	int arrayStack[];
	int top;
	int size;
	
	ArrayStack(int size){
		arrayStack = new int[size];
		top = -1;  //...since Stack has no elements. 
		size = 0;
	}
	
	@Override
	public void push(int data) throws StackOverflowException {
		if(top >= size - 1)
			throw new StackOverflowException();
		else {
			top++;
			arrayStack[top] = data;
		}
	}

	@Override
	public int pop() throws StackUnderflowException {
		int out = 0;
		if(top < 0 || size == 0)
			throw new StackUnderflowException();  // EmptyStackException
		else {
			out = arrayStack[top];
			top--;
		}
		return out;
	}

	@Override
	public int peek() throws StackUnderflowException{
		if(top < 0 || size == 0)
			throw new StackUnderflowException(); 
		else 
			return arrayStack[top];
	}

	@Override
	public void display() {
		for(int i=0; i<=top; i++) {
			System.out.print(arrayStack[i]+" ");
		}
		System.out.println();
	}

	@Override
	public void destroy() {
		while(top != -1) {
			arrayStack[top] = 0;
			top--;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return top+1;
	}

}
