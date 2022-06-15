package sort;

import java.util.Arrays;
import common.CommonUtility;

public class BinaryInsertionSort extends CommonUtility{

	public static void main(String[] args)
    {
		int arr[] = {100, 80, 90, 10, 30, 50, 20};
  
        new BinaryInsertionSort().sort(arr);
  
        display(arr);
    }
  
    public void sort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int x = array[i];
  
            // Find location to insert using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);
  
            //Shifting array to one location right
            System.arraycopy(array, j, array, j+1, i-j);
  
            //Placing element at its correct location
            array[j] = x;
        }
    }

}


