package linked_list.circular;

public class CircularLL {

	public static void main(String[] args) {
		
		
		
	}

}

class CircularLLOperations{
	
	public int size = 0;
	public CircularNode head = null;
	public CircularNode tail = null;
	
	public CircularNode insertRear(CircularNode rear, int data) {
		CircularNode temp = new CircularNode(data);
		if(rear == null) {
			rear = temp;
			temp.next = temp;
		}else {
			temp.next = rear.next;
			rear.next = temp;
			rear = temp;
		}
		return rear;
	}
	
	public void insertFront( int data) {
		CircularNode temp = new CircularNode(data);
		/*
		if(rear == null) {
			rear = temp;
			temp.next = temp;
		}else {
			temp.next = rear.next;
			rear.next = temp;
		}
		return rear;
		*/
		
		CircularNode newNode = new CircularNode(data);
		
	    //Checks if the list is empty.   
	    if (head == null) {
	    	
	      //If list is empty, both head and tail would point to new node.   
	    	head = newNode;
	    	tail = newNode;
	    	newNode.next = head;
	      
	    } else {
	    	
	        //Store data into temporary node   
	    	CircularNode temp2 = head;
	    	
	    	//New node will point to temp as next node   
	    	newNode.next = temp2;
	    	
	    	//New node will be the head node   
	    	head = newNode;
	    	
	    	//Since, it is circular linked list tail will point to head.   
	    	tail.next = head;
	    }
	}
	
	public void print(CircularNode rear) {
			
		CircularNode temp = head;
		do {
			System.out.print(" " + temp.data);
			temp = temp.next;
		} while(temp != head);
		System.out.println();
		
	}
	
	public int count() {
		int size = 0;
		if(head != null) {
			CircularNode temp = head;
			while(temp.next != head) {
				temp = temp.next;
				size++;
			}
			size++;
		}
		return size;
	}
	
	public void deleteNode(int data) {
		if (head == null)
		      System.out.println("List is empty");
		
		CircularNode current = head;
		CircularNode previous = new CircularNode();
		
		while (current.data != data) {
			previous = current;
			current = current.next;
		}
		if (current == head && current.next == head) {
		    head = null;
		}
		if(current == head) {
			previous = head;
			while (previous.next != head) {
		        previous = previous.next;
		    }
		    head = current.next;
		    previous.next = head;
		}
		else if(current.next == head) {
			previous.next = head;
		}else {
			previous.next = current.next;
		}
	}
}

class CircularNode {
	
	int data;
	CircularNode next;
	
	public CircularNode(int data){
		this.data = data;
	}
	
	public CircularNode() {}
}
