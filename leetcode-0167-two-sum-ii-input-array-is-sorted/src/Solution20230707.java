import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else { // numbers[i] + numbers[j] == target
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("Array: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Result: " + Arrays.toString(solution.twoSum(nums, target)) + ", actual: [1,2]");

        System.out.println();
        nums = new int[]{2, 3, 4};
        target = 6;
        System.out.println("Array: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Result: " + Arrays.toString(solution.twoSum(nums, target)) + ", actual: [1,3]");

        System.out.println();
        nums = new int[]{-1, 0};
        target = -1;
        System.out.println("Array: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Result: " + Arrays.toString(solution.twoSum(nums, target)) + ", actual: [1,2]");
    }
}
