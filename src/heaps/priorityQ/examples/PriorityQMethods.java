package heaps.priorityQ.examples;

import java.util.PriorityQueue;

public class PriorityQMethods {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> intQ = new PriorityQueue<>();
	    // offer() and add() are used to add elements

	    intQ.add(51);
	    intQ.offer(6);
	    intQ.add(72);
	    intQ.add(1);
	    intQ.add(2);
	    intQ.offer(3);
	    intQ.offer(4);
	    intQ.add(11);
	    intQ.add(19);

	    System.out.println("Elements in this queue are: ");
	    System.out.println(intQ);

	    // printing size of the queue
	    System.out.println("Size of this queue is: " + intQ.size());

	    // removing values based on priority and printing them
	    System.out.println("Priority Queue:");
	    while(!intQ.isEmpty()){
	      System.out.println(intQ.remove());
	    }

	}

}
