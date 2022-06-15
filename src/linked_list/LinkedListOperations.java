package linked_list;

import java.util.Scanner;

import linked_list.exceptions.ElementNotFoundException;
import linked_list.exceptions.EmptyListException;

public class LinkedListOperations {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		LinkedList list = new LinkedList();

		while(true) {

			System.out.println("\nEnter Choice :"+
					"\n 1. Insert Beginning"+
					"\n 2. Insert Ending"+
					"\n 3. Insert at Index"+
					"\n 4. Insert after" +
					"\n 5. Delete Beginning"+
					"\n 6. Delete Ending"+
					"\n 7. Delete Element"+
					"\n 8. Delete Position" +
					"\n 9. Traverse"+
					"\n 10. Replace"+
					"\n 11. Count"+
					"\n 12. Search"+
					"\n 13. Is Empty ?"+
					"\n 14. Exit");

			int choice = scan.nextInt();
			if(choice > 15 || choice < 0) {
				System.out.println("\nPlease Enter Valid Choice");
				break;
			}

			switch (choice) {

			case 1: //insert beg
				System.out.println("Enter data to insert:");
				int data = scan.nextInt();
				list.insertBeginning(data);
				break;

			case 2: //end
				System.out.println("Enter data to insert:");
				int x = scan.nextInt();
				list.insertEnd(x);
				break;

			case 3: //index
				System.out.println("Enter index");
				int i = scan.nextInt();
				System.out.println("Enter data to insert:");
				int y = scan.nextInt();
				list.insertAtIndex(i, y);
				break;

			case 4:  //after
				System.out.println("insert after element :");
				int ele = scan.nextInt();
				System.out.println("Enter data to insert :");
				int z = scan.nextInt();
				try {
					list.insertPosition(ele, z);
				} catch (ElementNotFoundException e1) {
					e1.printStackTrace();
				}
				break;

			case 5://delete beg
				System.out.println("Delete element from beginning :");
				try {
					list.deleteBeginning();
				} catch (EmptyListException e1) {
					e1.printStackTrace();
				}
				break;

			case 6:// end
				System.out.println("Delete element from ending :");
				try {
					list.deleteEnd();
				} catch (EmptyListException e1) {
					e1.printStackTrace();
				}
				break;


			case 7://index
				System.out.println("Delete element at index :");
				int index = scan.nextInt();
				try {
					list.deletePosition(index);
				} catch (EmptyListException e1) {
					e1.printStackTrace();
				}
				break;

			case 8://data
				System.out.println("Delete element :");
				int element = scan.nextInt();
				try {
					list.deleteElement(element);
				} catch (EmptyListException | ElementNotFoundException e1) {
					e1.printStackTrace();
				}
				break;

			case 9:
				try {
					System.out.println("Display list data:");
					list.traverse();
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;


			case 10: //replce
				System.out.println("Enter key to replace :");
				int oldData = scan.nextInt();
				System.out.println("Enter new data :");
				int newData = scan.nextInt();
				try {
					list.replace(oldData, newData);
				} catch (EmptyListException | ElementNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 11: //count 
				System.out.println("count :"+list.count());
				break;

			case 12: //search
				System.out.println("Search key");
				int key = scan.nextInt();
				try {
					System.out.println("Element found at :"+list.search(key));
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;

			case 13: //isEmpty
				System.out.println("Linked List is empty ?"+list.isEmpty());
				break;
				
			case 14:
				System.out.println("Reverse Linked List");
				try {
					list.reverse();
				} catch (EmptyListException e) {
					e.printStackTrace();
				}
				break;
				
			case 15: 
				System.exit(0);
				break;
				
			}

		}

	}

}
