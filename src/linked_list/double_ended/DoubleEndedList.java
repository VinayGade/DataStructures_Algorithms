package linked_list.double_ended;

import linked_list.exceptions.EmptyListException;

public class DoubleEndedList {

	private Node first;
	private Node last;

	public DoubleEndedList() {
		first = null;
		last = null;
	}

	public DoubleEndedList(Node first, Node last) {
		super();
		this.first = first;
		this.last = last;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node node = new Node(data);
		if(isEmpty())
			last=node;

		node.next=first;
		first=node;
	}

	public void insertLast(int data) {
		Node node = new Node(data);
		if(isEmpty())
			first=node;
		else
			last.next=node;
		last=node;
	}

	public void deleteFirst() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException();
		else {
			int key = first.data;
			if(first.next == null)
				last = null;
			else 
				first = first.next;
			System.out.println("Deleted first node:"+key);
		}
	}

	public void deleteLast() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException();
		else {
			int key = last.data;
			if(first == last || first.next == null)
				last = null;
			else {
				
				Node temp = first;
				while(true) {
					if(temp.next.next == null) {
						temp.next = null;
						last = temp;
						break;
					}	
					temp = temp.next;
				}
			}
			System.out.println("Deleted last node:"+key);
		}

	}
	
	public void display() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException();
		else {
			System.out.println("Double Ended List Data");
			Node temp = first;
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
	}
	
	public int size() {
		int n = 0;
		if(!isEmpty()) {
			Node temp = first;
			while(temp!=null) {
				temp=temp.next;
				n++;
			}
		}
		return n;	
	}
}
