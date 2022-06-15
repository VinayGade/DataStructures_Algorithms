package heaps.priorityQ.examples;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQComparatorDemo {

	public static void main(String[] args) {
		
		// Creating an empty Priority_Queue
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
 
        // Adding elements to the queue
        queue.add(20);
        queue.add(24);
        queue.add(30);
        queue.add(35);
        queue.add(45);
        queue.add(50);
 
        System.out.println("Priority queue values are: " + queue);
        
        // Creating a comparator
        Comparator comp = queue.comparator();
 
        // Displaying the comparator values
        System.out.println("Since the Comparator value is: " + comp);
        System.out.println("it follows natural ordering");
		
	}

}
