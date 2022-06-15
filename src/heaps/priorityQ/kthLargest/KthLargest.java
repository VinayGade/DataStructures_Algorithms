package heaps.priorityQ.kthLargest;

import java.util.PriorityQueue;
import java.util.Collections;

public class KthLargest {

	// 20 10 60 30 50 40
	public static void main(String[] args) {
		
		int a[]= {20, 10, 60, 30, 50, 40};
		int k = 3;
		
		int largest = priorityQueueLargest(a, k);
		
		int smallest = priorityQueueSmallest(a, k);
		
		System.out.println(k+" th largest ="+largest);
		
		System.out.println(k+" th smallest ="+smallest);
	}
	
	public static int priorityQueueLargest(int a[], int k) {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		for(int i=0; i<k; i++) {
			priorityQueue.add(a[i]);
		}
		
		for(int i=k; i<a.length; i++) {
			if(priorityQueue.peek() < a[i]) {
				priorityQueue.poll();
				priorityQueue.add(a[i]);
			}
		}
		
		return priorityQueue.peek();
	}
	
	public static int priorityQueueSmallest(int a[], int k) {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<k; i++) {
			priorityQueue.add(a[i]);
		}
		
		for(int i=k; i<a.length; i++) {
			if(priorityQueue.peek() > a[i]) {
				priorityQueue.poll();
				priorityQueue.add(a[i]);
			}
		}
		
		return priorityQueue.peek();
		
	}

}
