package binarysearch;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/24
 */
public class BinarySearch4 {

    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = searchUpper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

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
            System.out.print(ceil(arr, i) + " ");
        }
        System.out.println();
    }
}
