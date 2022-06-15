package linked_list.circular;

public class CircularLinkedList {

	Node head, tail;
    
	public void addNode(int value) {
	    Node newNode = new Node(value);

	    if (head == null) 
	        head = newNode;
	    else 
	        tail.nextNode = newNode;
	    
	    tail = newNode;
	    tail.nextNode = head;
	}
	
	CircularLinkedList createCircularLinkedList() {
	    CircularLinkedList cll = new CircularLinkedList();

	    cll.addNode(13);
	    cll.addNode(7);
	    cll.addNode(24);
	    cll.addNode(1);
	    cll.addNode(8);
	    cll.addNode(37);
	    cll.addNode(40);
	    cll.addNode(46);

	    return cll;
	}

	public boolean containsNode(int searchValue) {
	    Node currentNode = head;

	    if (head != null)  {
	        do {
	            if (currentNode.value == searchValue) {
	                return true;
	            }
	            currentNode = currentNode.nextNode;
	        } while (currentNode == tail);        
	    }
	    return false;
	}
	
	public void deleteNode(int valueToDelete) {
	    Node currentNode = head;
	    if (head == null)  // the list is empty
	        return;
	    
	    do {
	        Node nextNode = currentNode.nextNode;
	        if (nextNode.value == valueToDelete) {
	            if (tail == head) { // the list has only one single element
	                head = null;
	                tail = null;
	            } else {
	                currentNode.nextNode = nextNode.nextNode;
	                if (head == nextNode) { //we're deleting the head
	                    head = head.nextNode;
	                }
	                if (tail == nextNode) { //we're deleting the tail
	                    tail = currentNode;
	                }
	            }
	            break;
	        }
	        currentNode = nextNode;
	    } while (currentNode == tail);
	}
	
	public void traverseList() {
	    Node currentNode = head;

	    if (head != null) {
	        do {
	            System.out.println(currentNode.value + " ");
	            currentNode = currentNode.nextNode;
	        } while (currentNode == tail);
	    }
	}
    
}
