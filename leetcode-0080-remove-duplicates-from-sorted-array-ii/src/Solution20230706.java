import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/6
 */
public class Solution20230706 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int k = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                if (k + 1 != i) {
                    swap(nums, i, k + 1);
                }
                k++;
            }
        }
        return k + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution20230706 solution = new Solution20230706();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println("Before: " + Arrays.toString(nums) + ", result: " + solution.removeDuplicates(nums) + ", After: " + Arrays.toString(nums));

        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println("Before: " + Arrays.toString(nums) + ", result: " + solution.removeDuplicates(nums) + ", After: " + Arrays.toString(nums));
    }
}
