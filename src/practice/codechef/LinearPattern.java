package practice.codechef;

import java.util.Scanner;

public class LinearPattern {

	public static void main(String[] args) {
		//n=9
		//10,2,20,4,30,6,40,8,50

		//i=10, j=2

		Scanner scanner = new Scanner(System.in);
		int n= scanner.nextInt();
		
		int pattern[]= linearPattern(n);
		
		for(int i=0;i<n;i++) {
			System.out.print(pattern[i]+" ");
		}

	}
	
	public static int[] linearPattern(int n) {
		int pattern[]=new int[n];

		int i=0;
		int x = 10;
		int y = 2;
		while(i<n) {
			if(i%2==0) {
				pattern[i]=x;
				x+=10;
			}else {
				pattern[i]=y;
				y+=2;
			}
			i++;
		}
		
		return pattern;
	}

}
