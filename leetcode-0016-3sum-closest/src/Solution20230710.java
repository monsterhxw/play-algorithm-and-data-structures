import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/10
 */
public class Solution20230710 {

    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) {
                    if (sum - target < minDiff) {
                        minDiff = sum - target;
                        res = sum;
                    }
                    r--;
                } else if (sum < target) {
                    if (target - sum < minDiff) {
                        minDiff = target - sum;
                        res = sum;
                    }
                    l++;
                } else { // sum == target
                    return sum;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();
        int[] nums;
        int target;

        nums = new int[]{-1, 2, 1, -4};
        target = 1;
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.threeSumClosest(nums, target));


        nums = new int[]{0, 0, 0};
        target = 1;
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.threeSumClosest(nums, target));

    }
}
