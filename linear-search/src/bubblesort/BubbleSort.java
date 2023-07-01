package bubblesort;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/28
 */
public class BubbleSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean isSwapped = false;
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    swap(data, j - 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = 0; i < data.length; ) {
            int lastSwappedIndex = 0;
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    swap(data, j - 1, j);
                    lastSwappedIndex = j;
                }
            }
            i = data.length - lastSwappedIndex;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 2, 4, 6, 1, 5};
        sort2(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
