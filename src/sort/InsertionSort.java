package sort;

import common.CommonUtility;

public class InsertionSort extends CommonUtility{

	public static void main(String[] args) {
        int arr[] = {100, 80, 90, 10, 30, 50, 20};
        insertionSort(arr);
        display(arr);
    }

    // This function sorts array from left index to
    // to right index which is of size atmost RUN
    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
