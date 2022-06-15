package heaps.priorityQ.kthLargest;

public class KthLargestSorting {

	public static void main(String[] args) {

		KthLargestSorting quick = new KthLargestSorting();
		int nums[] = {50, 30, 10, 20, 80, 15, 40};
		int k = 3;
		int kthLargest = quick.findKthLargest(nums, k);
		System.out.println("K th Largest Element = "+kthLargest);
		
	}

	public int findKthLargest(int[] nums, int k) {
		QuickSelect quickSelect = new QuickSelect();
		return quickSelect.findKthLargestElement(nums, k);
	}

}
