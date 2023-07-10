import java.util.*;

/**
 * @author huangxuewei
 * @since 2023/7/10
 */
public class Solution20230710 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> records1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            records1.put(key, records1.getOrDefault(key, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (records1.containsKey(key) && records1.get(key).compareTo(0) > 0) {
                list.add(key);
                records1.put(key, records1.get(key) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();

        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2) + ", result: " + Arrays.toString(solution.intersect(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2) + ", result: " + Arrays.toString(solution.intersect(nums1, nums2)));
    }
}
