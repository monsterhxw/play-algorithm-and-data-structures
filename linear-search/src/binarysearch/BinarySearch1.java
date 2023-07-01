package binarysearch;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/24
 */
public class BinarySearch1 {

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        return search(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int search(E[] data, int l, int r, E target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        } else if (data[mid].compareTo(target) > 0) {
            return search(data, l, mid - 1, target);
        } else { // data[mid] < target
            return search(data, mid + 1, r, target);
        }
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
