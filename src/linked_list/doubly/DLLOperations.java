package linked_list.doubly;

import java.util.Scanner;

import linked_list.exceptions.EmptyListException;

public class DLLOperations {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		DoublyLinkedList doublyList = new DoublyLinkedList();

		while(true) {

			System.out.println("\nEnter Choice :"+
					"\n 1. Insert Beginning"+
					"\n 2. Insert Ending"+
					"\n 3. Traverse"+
					"\n 4. Insert after" +
					"\n 5. Delete Beginning"+
					"\n 6. Delete Ending"+
					"\n 7. Delete Element"+
					"\n 8. Count"+
					"\n 9. Is Empty ?"+
					"\n 10. reverse"+				
					"\n 11. Search"+				
					"\n 12. Exit");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:	
				System.out.println("Enter data:");
				int data = scan.nextInt();
				doublyList.insertBegin(data);
				break;

			case 2:	
				System.out.println("Enter data:");
				int ele = scan.nextInt();
				doublyList.insertEnd(ele);
				break;

			case 3:	
				System.out.println("Display list data :");
				doublyList.display();
				break;

			case 4:	
				System.out.println("Insert after element :");
				int k = scan.nextInt();
				System.out.println("Data to insert :");
				int x = scan.nextInt();
				doublyList.insertAfter(k, x);
				break;

			case 5:	
				try {
					doublyList.deleteBegin();
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;

			case 6:	
				try {
					doublyList.deleteEnd();
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;

			case 7:	
				System.out.println("Enter element to delete :");
				int n = scan.nextInt();
				try {
					doublyList.delete(n);
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;

			case 8:	
				System.out.println("Size of Linked list:"+doublyList.count());
				break;

			case 9:	//isempty
				System.out.println("Empty Linked list ? "+doublyList.isEmpty());
				break;

			case 10:	 //replace
				System.out.println("List in reverse order :");
				doublyList.reverse();
				break;

			case 11:	 //search
				System.out.println("Enter key:");
				int v = scan.nextInt();
				try {
					doublyList.search(v);
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;

			case 12:	break;
			}

		}
	}

}
