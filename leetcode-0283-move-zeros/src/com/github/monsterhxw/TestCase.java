package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/3/14
 */
public class TestCase {

    static void solution01() {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        Solution01 solution01 = new Solution01();
        solution01.moveZeroes(nums);

        System.out.println("Result is: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        solution01();
    }
}
