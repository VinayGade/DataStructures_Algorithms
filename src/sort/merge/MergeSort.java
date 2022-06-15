package sort.merge;

public class MergeSort {

public static void main(String args[]) {
		
		
		int a[] = {100, 90, 20, 40, 10, 80, 60, 30};
		int n = a.length;

		mergeSort(a, 0, n-1);
		
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
        System.out.println();

	}

	public static void merge(int a[], int left, int mid, int right){

		int c[] = new int[a.length]; 
		int i = left;
		int j = mid+1;
		int k = 0;

		while(i <= mid && j <= right){

			if(a[i] < a[j]){
				c[k] = a[i];
				i++;
			}else{
				c[k] = a[j];
				j++;
			}
			k++;
		}

		while(i <= mid){
			c[k]=a[i];
			i++;
			k++;
		}

		while(j <= right){
			c[k]=a[j];
			j++;
			k++;
		}

		for( i=left, j=0; i<=right; i++, j++)
			a[i]=c[j];

	}

	public static void mergeSort(int a[], int left, int right){

		if(left < right){
			int mid = (left + right)/2;
			mergeSort( a, left, mid);
			mergeSort( a, mid+1, right);
			merge(a, left, mid, right);
		}

	}

}
