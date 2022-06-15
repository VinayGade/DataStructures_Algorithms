package stack;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

public interface StackADT {
	void push(int x) throws StackOverflowException;
	int pop() throws StackUnderflowException;
	int peek() throws StackUnderflowException;
	void display();
	void destroy() throws StackUnderflowException;
	//int top();
	boolean isEmpty();
	int size();
}
