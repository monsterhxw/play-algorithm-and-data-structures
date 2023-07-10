import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/10
 */
public class Solution20230710 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else { // sum == 0
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
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

        return res;
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();
        int[] nums;

        nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.threeSum(nums));

        nums = new int[]{0, 1, 1};
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.threeSum(nums));

        nums = new int[]{0, 0, 0};
        System.out.println("nums: " + Arrays.toString(nums) + ", result: " + solution.threeSum(nums));
    }
}
