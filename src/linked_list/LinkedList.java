package linked_list;

import linked_list.exceptions.ElementNotFoundException;
import linked_list.exceptions.EmptyListException;

public class LinkedList {

	private LinkedNode head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int search(int key) throws EmptyListException {
		int index = -1;
		if(isEmpty())
			throw new EmptyListException();

		// throw EmptyListException
		LinkedNode temp = head;
		while(temp != null) {
			index++;
			if(temp.data == key) 
				break;
			temp = temp.next;
		}
		return index;
	}

	public void traverse() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException();
		LinkedNode temp = head;
		while(temp != null) {
			System.out.print(" "+temp.data);
			temp = temp.next;
		}
	}

	public int count() {
		int n = 0;
		if(head != null) {
			LinkedNode temp = head;
			while(temp != null) {
				temp = temp.next;
				n++;
			}
		}
		return n;	
	}

	public void insertBeginning(int data) {
		LinkedNode node = new LinkedNode(data);
		node.next = head;
		head = node;
	}

	public void insertEnd(int data) {
		LinkedNode node = new LinkedNode(data);
		if(isEmpty())
			head = node;
		else {
			LinkedNode temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public void insertPosition(int key, int data) throws ElementNotFoundException{  //insert after node with "data"
		LinkedNode node = new LinkedNode(data);
		if(isEmpty())
			head = node;
		else {
			LinkedNode temp = head;
			while(temp.data != key) {
				temp=temp.next;
			}
			if(temp.data == key) {
				LinkedNode x = temp.next;
				temp.next = node;
				node.next = x;
			}
			else {
				throw new ElementNotFoundException();
			}
		}
	}

	public void insertAtIndex(int index, int data) {
		LinkedNode node = new LinkedNode(data);
		if(isEmpty())
			head = node;
		LinkedNode temp = head;
		for(int i = 0; i<index-1; i++) {
			temp=temp.next;
		}
		node.next=temp.next;
		temp.next=node;	
	}

	public void replace(int key, int data) throws EmptyListException, ElementNotFoundException{       // Replace key with data
		//LinkedNode node = new LinkedNode(data);
		if(isEmpty())
			throw new EmptyListException();
		LinkedNode temp = head;
		while(temp!=null) {
			if(temp.data == key) {
				temp.data = data;
				break;
			}
			temp=temp.next;
		}
		if(temp == null)
			throw new ElementNotFoundException();
	}


	public int deleteBeginning() throws EmptyListException{
		if(isEmpty()) 
			throw new EmptyListException();
				
		LinkedNode removed = head;
		head = head.next;
		return removed.data;
	}

	public int deleteEnd() throws EmptyListException {
		if(isEmpty()) {
			throw new EmptyListException();
		}
		LinkedNode removed = head;
		while(removed.next.next != null) {
			removed = removed.next;
		}
		removed.next = null;
		return removed.data;
	}

	public int deletePosition(int index) throws EmptyListException {
		if(isEmpty()) {
			throw new EmptyListException();
		}
		LinkedNode x = head;
		for(int i = 0; i < index-1; i++) 
			x = x.next;
		LinkedNode removed = x.next;
		x.next = removed.next;
		return removed.data;
	}

	public int deleteElement(int key) throws EmptyListException, ElementNotFoundException {
		if(isEmpty()) {
			throw new EmptyListException();
		}
		LinkedNode temp = head;
		LinkedNode removed = temp;
		while(temp != null) {
			if(temp.next.data == key) {
				removed = temp.next;
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}
		if(temp == null)
			throw new ElementNotFoundException();
		return removed.data;
	}	

	public void reverse() throws EmptyListException {

		//tricky

		if (isEmpty()) 
			throw new EmptyListException();
		else if(head.next == null)
			return;

		LinkedNode q = null;
		LinkedNode p = head;
		LinkedNode r;

		while(p != null) {
			r = p.next;
			p.next = q;
			q = p;
			p = r;
		}

		head = q;
	}

	public LinkedNode recursiveReverse(LinkedNode head) throws EmptyListException {
		LinkedNode node = head;

		if (isEmpty()) {
			throw new EmptyListException();
		}

		else if (head.next == null) {
			return head;
		}

		LinkedNode remaining = recursiveReverse(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}
}
