package sort;

import common.CommonUtility;

public class SelectionSort extends CommonUtility {
    public static void main(String[] args) {
        int arr[] = {100, 80, 90, 10, 30, 50, 20};
        
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(arr);
        display(arr);
    }

    public void selectionSort(int[] arr){
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;

            // Swap the found minimum element with the first element
            swap(min,i,arr);
        }
    }
}