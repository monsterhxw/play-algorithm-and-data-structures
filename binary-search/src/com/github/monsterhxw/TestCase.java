package com.github.monsterhxw;

/**
 * @author Xuewei Huang
 * @since 2023-02-28
 */
public class TestCase {
    
    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 6, 8, 10, 12};
        int pos = BinarySearch.binarySearch(nums, 8);
        System.out.println(pos == 3);
    }
}
