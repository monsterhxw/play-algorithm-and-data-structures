import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return selectK(nums, nums.length - k, 0, nums.length - 1, random);
    }

    private int selectK(int[] nums, int k, int l, int r, Random random) {
        int p = partition2Way(nums, l, r, random);
        if (k == p) {
            return nums[p];
        }
        return k < p ? selectK(nums, k, l, p - 1, random) : selectK(nums, k, p + 1, r, random);
    }

    private int partition2Way(int[] nums, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);
        int v = nums[l];

        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && nums[i] < v) {
                i++;
            }
            while (i <= j && nums[j] > v) {
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

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.add(nums[i]);
                continue;
            }
            if (nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

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
