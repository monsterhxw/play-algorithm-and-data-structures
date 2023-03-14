package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/3/14
 */
public class TestCase {

    static void solution01() {
        System.out.println("Solution01");

        int[] nums = new int[]{1, 1, 2};
        System.out.println("nums is: " + Arrays.toString(nums));

        Solution01 solution = new Solution01();
        int newLen = solution.removeDuplicates(nums);
        System.out.println("nums is: " + Arrays.toString(nums) + ", new length is: " + newLen);
    }

    public static void main(String[] args) {
        solution01();
    }
}
