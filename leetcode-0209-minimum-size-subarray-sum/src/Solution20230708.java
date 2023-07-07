import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/8
 */
public class Solution20230708 {

    public int minSubArrayLen(int target, int[] nums) {
        int ret = nums.length + 1;

        int l = 0;
        int r = -1;
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < target) {
                r++;
                sum = sum + nums[r];
            } else {
                sum = sum - nums[l];
                l++;
            }
            if (sum >= target) {
                if (r - l + 1 < ret) {
                    ret = r - l + 1;
                }
            }
        }

        return ret == nums.length + 1 ? 0 : ret;
    }

    public static void main(String[] args) {
        Solution20230708 solution = new Solution20230708();

        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};

        System.out.println("Array: " + Arrays.toString(nums) + ", target: " + target + ", result: " + solution.minSubArrayLen(target, nums));

        System.out.println();
        target = 4;
        nums = new int[]{1, 4, 4};
        System.out.println("Array: " + Arrays.toString(nums) + ", target: " + target + ", result: " + solution.minSubArrayLen(target, nums));

        System.out.println();
        target = 11;
        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Array: " + Arrays.toString(nums) + ", target: " + target + ", result: " + solution.minSubArrayLen(target, nums));
    }
}
