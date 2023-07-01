package binarysearch;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/24
 */
public class BinarySearch2 {

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;

        // 在 data[l,r] 的范围中查找 target
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                // data[mid].compareTo(target) < 0)
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int target = 10;
        int search = search(nums, target);
        System.out.println(Arrays.toString(nums));
        System.out.println("search target=" + target + ", index=" + search);
    }
}
