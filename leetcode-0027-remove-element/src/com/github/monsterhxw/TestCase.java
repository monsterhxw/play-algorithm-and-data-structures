package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/3/14
 */
public class TestCase {

    static void solution01() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;

        System.out.println("Solution01 nums is: " + Arrays.toString(nums) + ", val is: " + val);

        Solution01 solution = new Solution01();
        int newLength = solution.removeElement(nums, val);

        System.out.println("Solution01 result is: " + Arrays.toString(nums) + ", new length is: " + newLength);
    }

    public static void main(String[] args) {
        solution01();
    }
}
