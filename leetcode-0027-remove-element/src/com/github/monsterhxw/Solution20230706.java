package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/6
 */
public class Solution20230706 {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution20230706 solution = new Solution20230706();

        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(Arrays.toString(nums) + ", val: " + val);
        System.out.println("Result: " + solution.removeElement(nums, val));

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        System.out.println(Arrays.toString(nums) + ", val: " + val);
        System.out.println("Result: " + solution.removeElement(nums, val));
    }
}
