package practice.gfg.sde_series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Google
//Given an array A of size N. The elements of the array consists of positive integers. 
// You have to find the largest element with minimum frequency.
/*
 Input:
1
5
2 2 5 50 1

Output:
50
 * */
public class FrequencyGame {

	public static void main(String[] args) {
		
		int arr [] = {2, 2, 5, 50, 1};
		int n = arr.length;
		//System.out.println(LargButMinFreq(arr,n));
		 int k =2;
		int [] klargest = kLargest(arr,n,k);
		for(int i:klargest)
			System.out.println(i);
	}
	
	public static int LargButMinFreq(int arr[], int n)
    {
        Map<Integer,Integer> numberFrequency = findNumberFrequency(arr,n);
        
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(numberFrequency.keySet());	
          
        int max = numbers.get(numbers.size()-1);
        int maxFreqency = numberFrequency.get(max);
        if(maxFreqency > 1){
        	for(int i: numbers) {
        		if(numberFrequency.get(i) < maxFreqency) {
        			max = i;
        		}
        	}		       	
        }
        return max;
    }
    
    public static Map<Integer,Integer> findNumberFrequency(int arr[], int n){
        Map<Integer,Integer> numberFrequency = new TreeMap<>();
        
        for(int i=0; i<n; i++){
            int element = arr[i];
            
            if(numberFrequency.containsKey(arr[i]))
                numberFrequency.put(element, numberFrequency.get(element)+1);
                
            else
                numberFrequency.put(element, 1);
            
        }
        return numberFrequency;
    }
    
    static int[] kLargest(int[] arr, int n, int k) {
       
        int klargest[] = new int[k];
        Arrays.sort(arr);
        for(int i =n-1, j=0; i>=(n-k) && j<k; i--, j++) {
        	
        	klargest[j] = arr[i];
        	
        }
        return klargest;
    }

}
