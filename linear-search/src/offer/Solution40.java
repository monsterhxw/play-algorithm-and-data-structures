package offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangxuewei
 * @since 2023/6/28
 */
public class Solution40 {

    public int[] getLeastNumber(int[] arr, int k) {
        // maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 2, 0, 5};
        int k = 0;
        int[] leastNumber = (new Solution40()).getLeastNumber(nums, k);
        System.out.println(Arrays.toString(leastNumber));
    }
}
