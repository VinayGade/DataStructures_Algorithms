package heaps.priorityQ;

import java.util.PriorityQueue;

public class PriorityQ {

	public static void main(String[] args) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.add(15);
		priorityQueue.add(10);
		priorityQueue.add(5);

		// default : MIN_HEAP

		System.out.println("Size = "+priorityQueue.size());

		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.peek());
			priorityQueue.poll();
		}

	}
}
