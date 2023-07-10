import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangxuewei
 * @since 2023/7/10
 */
public class Solution20230710 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();

        int[] nums;
        int target;

        nums = new int[]{2, 7, 11, 15};
        target = 9;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target + ", result: " + Arrays.toString(solution.twoSum(nums, target)));

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target + ", result: " + Arrays.toString(solution.twoSum(nums, target)));

        nums = new int[]{3, 3};
        target = 6;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target + ", result: " + Arrays.toString(solution.twoSum(nums, target)));
    }
}
