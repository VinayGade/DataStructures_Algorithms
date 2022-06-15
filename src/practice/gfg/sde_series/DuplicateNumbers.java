package practice.gfg.sde_series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Amazon :
// Identify duplicate elements in array
public class DuplicateNumbers {

	public static void main(String[] args) {
		int a[] = {10, 5, 20, 100, 20, 10, 120, 145, 200, 100};
		
		DuplicateNumbers dn = new DuplicateNumbers();
		List<Integer> duplicates = dn.findDuplicates(a);

		System.out.println(duplicates.isEmpty());
		duplicates.forEach(System.out::println);
	}
	
	public List<Integer> findDuplicates(int a[]){
		
		List<Integer> duplicates = new ArrayList<Integer>();
		Arrays.sort(a);
		for(int x: a)
			System.out.println(x);
		
		int n = a.length;
		for(int i=0; i<n-1; i++) {
			
			if(a[i] == a[i+1]) {
				duplicates.add(a[i]);
				while(a[i] == a[i+1] && i<n) 
					i++;		
			}
		}
		return duplicates;
	}

}
