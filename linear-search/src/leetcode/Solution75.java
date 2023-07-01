package leetcode;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/24
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        // nums[0,zero]=0
        // nums[zero+1,i]=1
        // nums[two,n-1]=2
        int zero = -1;
        int i = 0;
        int two = nums.length;
        int v = 1;

        while (i < two) {
            if (nums[i] < v) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] > v) {
                two--;
                swap(nums, i, two);
            } else { // nums[i] == v
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        (new Solution75()).sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
