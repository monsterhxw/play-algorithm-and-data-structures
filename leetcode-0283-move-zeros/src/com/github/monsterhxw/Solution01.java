package com.github.monsterhxw;

/**
 * @author huangxuewei
 * @since 2023/3/14
 */
public class Solution01 {

    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int firstZeroPos = 0;
        int currPos = 0;

        while (currPos < nums.length) {
            if (nums[currPos] != 0) {
                if (firstZeroPos != currPos) {
                    swap(nums, firstZeroPos, currPos);
                }
                firstZeroPos++;
            }
            currPos++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
