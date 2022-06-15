package practice.gfg.sde_series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Majority {

	public int majorityElement(final List<Integer> A) {

        int floor = A.size() / 2;

        Map<Integer, Integer> numberFrequency = new LinkedHashMap<>();
        for(int a : A){
        	
            if( numberFrequency.containsKey(a) )
                numberFrequency.put(a, numberFrequency.get(a) + 1);
            else
                numberFrequency.put(a, 1);
        }
        int majority=A.get(0);
        for( Map.Entry<Integer, Integer> numberFrequencyEntry : numberFrequency.entrySet() ){
            
            if(numberFrequencyEntry.getValue() >= floor && numberFrequencyEntry.getValue() > majority)
                majority = numberFrequencyEntry.getKey();
        }
        return majority;
    }
	
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(10, 20 ,30, 40, 50, 80);
		
		Majority majority = new Majority();
		int max = majority.majorityElement(nums);
		
		System.out.println("Max ="+ max);
	}
}
