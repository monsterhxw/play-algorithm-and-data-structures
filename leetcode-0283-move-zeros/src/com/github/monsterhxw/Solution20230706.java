package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/6
 */
public class Solution20230706 {

    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != zero) {
                    swap(nums, i, zero);
                }
                zero++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums));
        (new Solution20230706()).moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));

        nums = new int[]{1, 0, 1};
        System.out.println("Before: " + Arrays.toString(nums));
        (new Solution20230706()).moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));

        nums = new int[]{1, 2, 0, 3};
        System.out.println("Before: " + Arrays.toString(nums));
        (new Solution20230706()).moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
