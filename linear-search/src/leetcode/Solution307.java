package leetcode;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/28
 */
public class Solution307 {

    private int[] sums;

    private int[] data;

    public Solution307(int[] nums) {
        data = new int[nums.length];
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 6, 1, 5};
        Solution307 numArray = new Solution307(nums);
        System.out.println(Arrays.toString(numArray.sums));
        System.out.println(numArray.sumRange(0, 2));
    }
}
