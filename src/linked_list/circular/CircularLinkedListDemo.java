package linked_list.circular;

public class CircularLinkedListDemo {

	public static void main(String[] args) {
		
		Node last = null;
		 
	    last = addToEmpty(last, 6);
	    last = addBegin(last, 4);
	    last = addBegin(last, 2);
	    last = addEnd(last, 8);
	    last = addEnd(last, 12);
	    last = addAfter(last, 10, 8);
	 
	    traverse(last);

	}
	
	static Node addToEmpty(Node last, int data) {
		if(last != null) 
			return last;
		
		Node temp = new Node(data);
		last = temp;
		last.nextNode = last;
		
		return last;
	}

	static Node addBegin(Node last, int data) {
		if(last == null) 
			return addToEmpty(last, data);
		
		Node temp = new Node(data);
		
	    temp.nextNode = last.nextNode;
	    last.nextNode = temp;
		
		return last;
	}
	
	static Node addEnd(Node last, int data) {
		
		if (last == null)
	        return addToEmpty(last, data);
	     
	    Node temp = new Node(data);
	 
	    temp.nextNode = last.nextNode;
	    last.nextNode = temp;
	    last = temp;
		
		return last;
	}
	
	static Node addAfter(Node last, int data, int item) {
		
		if (last == null)
	        return null;
	 
	    Node temp, p;
	    p = last.nextNode;
	    
	    do
	    {
	        if (p.value == item)
	        {
	            temp = new Node(data);
	            temp.nextNode = p.nextNode;
	            p.nextNode = temp;
	 
	            if (p == last)
	                last = temp;
	            return last;
	        }
	        p = p.nextNode;
	        
	    } while(p != last.nextNode);
	 
	    System.out.println(item + " not present in the list.");
		
		return last;
	}
	
	static void traverse(Node last) {
		Node p;
		
		if(last == null) {
			System.out.println("List Empty");
			return;
		}
		p = last.nextNode;
		System.out.println("\n");
		
		do {
			System.out.print(p.value+" ");
			p = p.nextNode;
		}while(p != last.nextNode);
	}
}
