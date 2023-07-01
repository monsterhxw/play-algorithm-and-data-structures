package leetcode;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/28
 */
public class Solution303 {

    private int[] sums;

    public Solution303(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 6, 1, 5};
        Solution303 numArray = new Solution303(nums);
        System.out.println(Arrays.toString(numArray.sums));
        System.out.println(numArray.sumRange(0, 2));
    }
}
