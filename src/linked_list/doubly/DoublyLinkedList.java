package linked_list.doubly;

import java.util.Scanner;

import linked_list.exceptions.EmptyListException;

public class DoublyLinkedList {

	Scanner scan = new Scanner(System.in);
	
	DoublyLinkedNode first, last;
	
	DoublyLinkedList(){
		first = last = null;
	}
	
	boolean isEmpty() {
		return (first==null && last==null);
	}
	
	int count() {
		int n = 0;
		DoublyLinkedNode temp = first;
		while(temp != null) {
			n++;
			temp = temp.next;
		}
		return n;
	}
	
	public int search(int key) throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException();
		int i=0;
		DoublyLinkedNode temp = first;
		while(temp != null) {
			if(temp.data == key)
				break;
			temp = temp.next;
			i++;
		}
		return i;
	}
	
	void display() {
		if(isEmpty())
			return;
		DoublyLinkedNode temp = first;
		while(temp != null) {
			System.out.println(temp.data+" ");
			temp = temp.next;
		}
	}
	
	void reverse() {
		if(isEmpty())
			return;
		DoublyLinkedNode temp = last;
		while(temp != null) {
			System.out.println(temp.data+" ");
			temp = temp.prev;
		}
	}
	
	void insertBegin(int data) {
		DoublyLinkedNode temp = new DoublyLinkedNode(data);
		if(first == null && last == null)
			first = last = temp;
		else {
			temp.next = first;
			first.prev = temp;
			first = temp;
		}	
	}
	
	void insertEnd(int data) {
		DoublyLinkedNode temp = new DoublyLinkedNode(data);
		if(first == null && last == null)
			first = last = temp;
		else {
			last.next = temp;
			temp.prev = last;
			last = temp;
		}
	}
	
	void insertAfter(int key, int data) {
		DoublyLinkedNode temp = new DoublyLinkedNode(data);
		DoublyLinkedNode t = first;
		
		if(first == null && last == null) {
			first = last = temp;
			return;
		}
			while(t.next != null) {
			if(t.data == key) {
				temp.prev = t;
				temp.next = t.next;
				t.next.prev = temp;
				t.next = temp;
			}
			t = t.next;
		}
	}
	
	void deleteBegin() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException();
		else if(first == last) {
			System.out.println("Deleted Element : "+first.data);
			first = null;
			last = null;
		}else {
			first = first.next;
			first.prev = null;
		}
		
	}
	
	void deleteEnd() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException();
		else if(first == last) {
			System.out.println("Deleted Element : "+first.data);
			first = null;
			last = null;
		}else {
			last = last.prev;
			last.next = null;
		}
			
	}
	
	void delete(int key) throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException();
		else if(first == last) {
			System.out.println("Deleted Element : "+first.data);
			first = null;
			last = null;
		}else {
			DoublyLinkedNode t = last;
			while(t.prev != null) {
				if(t.data == key) {
					t.next.prev = t.prev;
					t.prev.next = t.next;   //can change order
					break;
				}else {
					t = t.prev;
				}
			}
		}
			
	}
}
