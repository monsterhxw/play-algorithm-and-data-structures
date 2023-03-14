package com.github.monsterhxw;

/**
 * @author huangxuewei
 * @since 2023/3/14
 */
public class Solution01 {

    /**
     * double pointer
     *
     * @param nums 数组
     * @param val  值
     * @return new length
     */
    public int removeElement(int[] nums, int val) {
        int k = 0, cur = 0, res = 0;

        while (cur < nums.length) {
            if (nums[cur] != val) {
                if (k != cur) {
                    swap(nums, k, cur);
                }
                k++;
                res++;
            }
            cur++;
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
