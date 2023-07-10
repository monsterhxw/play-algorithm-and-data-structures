import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/10
 */
public class Solution20230710 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > target && target > 0) {
                return res;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1; i < nums.length; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[k] + nums[i] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else { // sum == target
                        res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[l], nums[r])));
                        while (l + 1 < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (r - 1 > l && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();

        int[] nums;
        int target;

        nums = new int[]{1, 0, -1, 0, -2, 2};
        target = 0;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target + ", result: " + solution.fourSum(nums, target));

        nums = new int[]{2, 2, 2, 2, 2};
        target = 8;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target + ", result: " + solution.fourSum(nums, target));


        nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        target = 0;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target + ", result: " + solution.fourSum(nums, target));
    }
}
