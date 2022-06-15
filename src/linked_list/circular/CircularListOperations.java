package linked_list.circular;

public class CircularListOperations {

	public static void main(String[] args) {
		
		CircularLinkedList list = new CircularLinkedList();
		
		System.out.println("Performing Circular List operations");
		System.out.println("Create list :");
		list.createCircularLinkedList();
		
		System.out.println("Add node at the end :");
		list.addNode(90);
		
		System.out.println("Search node 40:" + list.containsNode(40));
		
		System.out.println("Traverse through list:");
		list.traverseList();
		
		System.out.println("Delete value 8");
		list.deleteNode(8);
		
		System.out.println("List after deletion");
		list.traverseList();
	}

}
