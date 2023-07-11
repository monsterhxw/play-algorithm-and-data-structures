import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huangxuewei
 * @since 2023/7/12
 */
public class Solution20230712 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution20230712 solution = new Solution20230712();
        int[] nums;

        nums = new int[]{1, 2, 3, 1};
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.containsDuplicate(nums));

        nums = new int[]{1, 2, 3, 4};
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.containsDuplicate(nums));

        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.containsDuplicate(nums));
    }
}
