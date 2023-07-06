package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/6
 */
public class Solution20230706 {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                if (k + 1 != i) {
                    swap(nums, k + 1, i);
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
        int[] nums = new int[]{1, 1, 2};
        System.out.println("Before: " + Arrays.toString(nums) + ", result: " + solution.removeDuplicates(nums) + ", After: " + Arrays.toString(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Before: " + Arrays.toString(nums) + ", result: " + solution.removeDuplicates(nums) + ", After: " + Arrays.toString(nums));
    }
}
