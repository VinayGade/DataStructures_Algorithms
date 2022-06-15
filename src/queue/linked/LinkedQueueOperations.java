package queue.linked;

import java.util.Scanner;

import queue.exceptions.ElementNotFoundException;
import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class LinkedQueueOperations {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter maximum capacity of queue :");
		int n = scan.nextInt();

		LinkedQueue queue = new LinkedQueue(n);

		int choice=0;

		do {
			System.out.println("\nEnter your choice: \n1. display \n2. is empty? \n3. search \n4. insert \n5. delete \n6.destroy \n7.Exit\n");
			choice = scan.nextInt();

			switch(choice) {

			case 1: 
				try {
					queue.display();
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("Q is empty ?"+queue.isEmpty());
				break;

			case 3:
				System.out.println("\nKey to be found :");
				int key = scan.nextInt();
				try {
					System.out.println("\n"+key +" found at "+queue.search(key));
				} catch (QueueUnderflowException | ElementNotFoundException e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("\nEnter element to enque :");
				int x = scan.nextInt();
				try {
					queue.enque(x);
				} catch (QueueOverflowException e) {
					e.printStackTrace();
				}
				break;
				
			case 5: 
				try {
					queue.deque();
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
				}
				break;
				
			case 6: 
				try {
					queue.destroy();
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
				}
				break;
				
			case 7: break;
			}

		}while(choice <= 7);

	}

}
