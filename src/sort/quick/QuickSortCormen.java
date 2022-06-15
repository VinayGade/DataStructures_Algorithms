package sort.quick;
import common.CommonUtility;
public class QuickSortCormen extends CommonUtility {

	public static void main(String[] args) {
		int a[] ={10, 7, 8, 9, 1, 5};

		new QuickSortCormen().quickSort(a, 0, a.length-1);

		System.out.println("after quick sort : \n");
		display(a);

	}

	public void quickSort(int a[], int p, int r) {
		if(p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
	}

	public int partition(int a[], int p, int r) {

		int x= a[r];
		int i= p-1;

		for(int j=p; j<r; j++) {

			if(a[j] <= x) {
				i++;
				swap(i, j, a);
			}
		}
		swap(i+1, r, a);
		return i+1;
	}
}