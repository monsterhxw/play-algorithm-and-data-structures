package leetcode;

public class Solution704 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        int cp = nums[mid] - target;
        if (cp == 0) {
            return mid;
        } else if (cp > 0) {
            return search(nums, l, mid - 1, target);
        } else { // nums[mid] < target
            return search(nums, mid + 1, r, target);
        }
    }

    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else { // nums[mid] < target
                l = mid + 1;
            }
        }
        return -1;
    }
}