package heaps.priorityQ.kthLargest;

public class QuickSelect {

    void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r];
        int p = l;
        for (int i = l; i < r; i += 1) {
            if (nums[i] <= pivot) {
                swap(nums, i, p);
                p += 1;
            }
        }
        swap(nums, p, r);

        if (k < p) {
            return quickSelect(nums, l, p - 1, k);
        }
        if (k > p) {
            return quickSelect(nums, p + 1, r, k);
        }
        return nums[p];
    }
 
    int findKthLargestElement(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        return quickSelect(nums, 0, n - 1, k);
    }
}
