package com.github.monsterhxw;

/**
 * @author Xuewei Huang
 * @since 2023-02-28
 */
public class BinarySearch {
    
    public static int binarySearch(int[] nums, int target) {
        // 在[left..right]的范围里寻找 target 的位置
        int left = 0;
        int right = nums.length - 1;
        
        // 当 left = right 时，区间 [left...right] 依然有效的
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1; // target 在 [left...mid-1] 中
            } else { // target > nums[mid]
                left = mid + 1; // target 在 [mid+1...right] 中
            }
        }
        
        return -1;
    }
}
