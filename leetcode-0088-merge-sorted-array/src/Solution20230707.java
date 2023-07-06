import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < m + n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] temp = new int[m + n];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            temp[i + m] = nums2[i];
        }

        int l = 0;
        int mid = m - 1;
        int r = m + n - 1;
        int i = l;
        int j = mid + 1;

        for (int k = l; k < r + 1; k++) {
            if (i > mid) {
                nums1[k] = temp[j - l];
                j++;
            } else if (j > r) {
                nums1[k] = temp[i - l];
                i++;
            } else if (temp[i] <= temp[j - l]) {
                nums1[k] = temp[i - l];
                i++;
            } else { // temp[i - l] > temp[j - l]
                nums1[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        Solution20230707 solution = new Solution20230707();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        System.out.println();
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        System.out.println();
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        System.out.println();
        nums1 = new int[]{4, 0, 0, 0, 0, 0};
        m = 1;
        nums2 = new int[]{1, 2, 3, 5, 6};
        n = 5;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
