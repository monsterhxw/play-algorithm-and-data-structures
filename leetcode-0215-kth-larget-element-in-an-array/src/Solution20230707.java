import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public int findKthLargest2(int[] nums, int k) {
        // 最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.remove();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return selectK(nums, 0, nums.length - 1, nums.length - k, random);
    }

    private int selectK(int[] nums, int l, int r, int k, Random random) {
        int p = partition2Way(nums, l, r, random);
        if (k == p) {
            return nums[p];
        }
        return k < p ? selectK(nums, l, p - 1, k, random) : selectK(nums, p + 1, r, k, random);
    }

    private int partition2Way(int[] nums, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);
        int v = nums[l];
        int i = l + 1;
        int j = r;
        // nums[l+1,i-1] <= v, nums[j+1,r] >= v
        while (true) {
            while (i <= j && nums[i] < v) {
                i++;
            }
            while (j >= i && nums[j] > v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Result:" + solution.findKthLargest(nums, k));

        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println("Result:" + solution.findKthLargest(nums, k));

        nums = new int[]{3, 2, 1, 5, 6, 4};
        k = 2;
        System.out.println("Result:" + solution.findKthLargest2(nums, k));

        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println("Result:" + solution.findKthLargest2(nums, k));
    }
}
