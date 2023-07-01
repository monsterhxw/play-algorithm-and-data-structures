package binarysearch;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/24
 */
public class BinarySearch3 {

    public static <E extends Comparable<E>> int searchUpper(E[] data, E target) {
        int l = 0;
        int r = data.length;

        // 在 data[l,r] 的范围中查找 target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) > 0) {
                r = mid;
            } else { // data[mid] <= target
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(searchUpper(arr, i) + " ");
        }
        System.out.println();

    }
}
