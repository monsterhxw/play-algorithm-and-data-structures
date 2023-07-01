package leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/24
 */
public class Solution215 {

    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length - 1, nums.length - k);
    }

    private int selectK(int[] arr, int l, int r, int k) {
        int p = partition(arr, l, r);
        if (k == p) {
            return arr[p];
        }
        return k < p ? selectK(arr, l, p - 1, k) : selectK(arr, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1,i-1] <= v, arr[j+1,r] >= v;
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i] < v) {
                i++;
            }
            while (j >= i && arr[j] > v) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest2 = (new Solution215()).findKthLargest2(nums, k);
        System.out.println(kthLargest2);
    }
}
