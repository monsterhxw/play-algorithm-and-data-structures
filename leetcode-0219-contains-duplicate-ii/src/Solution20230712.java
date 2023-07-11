import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huangxuewei
 * @since 2023/7/12
 */
public class Solution20230712 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (r - l > k) {
                set.remove(nums[l]);
                l++;
            }
            if (set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r]);
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;

        Solution20230712 solution = new Solution20230712();

        nums = new int[]{1, 2, 3, 1};
        k = 3;
        System.out.println("nums: " + Arrays.toString(nums) + ", k: " + k + ", result: " + solution.containsNearbyDuplicate(nums, k));

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        System.out.println("nums: " + Arrays.toString(nums) + ", k: " + k + ", result: " + solution.containsNearbyDuplicate(nums, k));

        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        System.out.println("nums: " + Arrays.toString(nums) + ", k: " + k + ", result: " + solution.containsNearbyDuplicate(nums, k));
    }
}
