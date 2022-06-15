package queue;

import java.util.Scanner;

import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class CirculrlarQDemo {

	public static void main(String[] args) {
		//insert delete display search empty
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter capacity of CircularQ :");
		int n =scan.nextInt();
		
		CircularQ q = new CircularQ(n);
		
		int choice = 0;
		do {
			
			System.out.println("\n Enter choice :\n1. insert \n2. delete \n3. display \n4. search \n5. empty \n6. Exit");
			choice = scan.nextInt();
			switch(choice) {

			case 1:

				try {
					System.out.println("Element to insert :");
					int x = scan.nextInt();
					q.enque(x);
				} catch (QueueOverflowException e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				try {
					System.out.println("Deleted element :" +q.deque());
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
				}
				break;
			case 3: 
				try {
					q.traverse();
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
				}
				break;
			case 4: 
				System.out.println("Enter key to search :");
				int key = scan.nextInt();
				try {
					q.search(key);
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Queue empty ?"+q.isEmpty());
				break;
			case 6: break;

			}

					
		}while(choice <= 6);

	}

}
