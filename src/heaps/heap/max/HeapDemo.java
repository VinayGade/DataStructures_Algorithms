package heaps.heap.max;

public class HeapDemo {

	public static void main(String[] args) {
		
		Heap heap = new Heap(10);
		
		//[ 80 75 60 65 55 40 52 67 ]
		
		heap.insert(80);
		heap.insert(75);
		heap.insert(60);
		heap.insert(65);
		
		heap.insert(55);
		heap.insert(40);
		heap.insert(52);
		heap.insert(67);
		
		heap.printHeap();
		
		/***** OPTIONAL *****/
		
		heap.delete(3);
		
		heap.printHeap();
		
		heap.insert(67);
		
		heap.printHeap();
		
	}

}
