package com.github.monsterhxw;

/**
 * @author huangxuewei
 * @since 2023/3/14
 */
public class Solution01 {

    public int removeDuplicates(int[] nums) {
        int k = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != nums[k]) {
                k++;
                if (k != cur) {
                    swap(nums, k, cur);
                }
            }
            cur++;
        }
        return k + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
