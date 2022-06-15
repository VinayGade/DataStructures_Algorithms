package sort.quick;

import common.CommonUtility;

public class QuickSort extends CommonUtility {

	public static void main(String[] args) {
		
		int arr[] = {100, 40 ,50, 10, 20 ,90, 30, 70};
		int n = arr.length; 

		QuickSort sort = new QuickSort(); 
		sort.quickSort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		display(arr);
	}
	
	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	
	public void quickSort(int arr[], int low, int high) {
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pivot = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			quickSort(arr, low, pivot-1); 
			quickSort(arr, pivot+1, high); 
		} 
		
	}
	
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	
	public int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) 
			{ 
				i++; 
				swap(i, j, arr);
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		swap((i+1), high, arr);
		return i+1; 
	} 
}
