import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huangxuewei
 * @since 2023/7/10
 */
public class Solution20230710 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> records = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            records.add(nums1[i]);
        }
        Set<Integer> results = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (records.contains(nums2[i])) {
                results.add(nums2[i]);
            }
        }
        int[] res = new int[results.size()];
        int i = 0;
        for (Integer result : results) {
            res[i] = result;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();

        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2) + ", result: " + Arrays.toString(solution.intersection(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2) + ", result: " + Arrays.toString(solution.intersection(nums1, nums2)));
    }
}
