package common;

public class CommonUtility {
	public static void display(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }	
	public int[] swap(int x, int y, int a[]) {
		int temp = a[x]; 
		a[x] = a[y]; 
		a[y] = temp;
		return a;
	}
}