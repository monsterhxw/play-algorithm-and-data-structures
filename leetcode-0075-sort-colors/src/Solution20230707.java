import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public void sortColors(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors3(int[] nums) {
        // nums[0,zero] == 0;
        int zero = -1;
        // nums[zero+1,i] == 1
        int i = 0;
        // nums[two,n-1] == 2;
        int two = nums.length;

        int v = 1;

        while(i < two) {
            if (nums[i] < v) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] > v) {
                two--;
                swap(nums, i, two);
            } else {
                // nums[i] == v
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();

        int[] nums = new int[]{2, 0, 2, 1, 1, 1, 0};
        System.out.println("Before: " + Arrays.toString(nums));
        solution.sortColors3(nums);
        System.out.println("After: " + Arrays.toString(nums));

        System.out.println();
        nums = new int[]{2, 0, 1};
        System.out.println("Before: " + Arrays.toString(nums));
        solution.sortColors3(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
