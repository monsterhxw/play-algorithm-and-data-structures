package heap;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/27
 */
public class HeapSort {

    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (int i = 0; i < data.length; i++) {
            maxHeap.add(data[i]);
        }
        for (int i = (data.length - 1); i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static <E extends Comparable<E>> void heapSort(E[] data) {
        heapify(data);
        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, i, 0);
            siftDown(data, 0, i);
        }
    }

    private static <E extends Comparable<E>> void heapify(E[] data) {
        if (data.length <= 1) {
            return;
        }
        int lastLeafParent = (data.length - 1 - 1) / 2;
        for (int i = lastLeafParent; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int size) {
        while (2 * k + 1 < size) {
            int j = 2 * k + 1;
            if (j + 1 < size && data[j + 1].compareTo(data[j]) > 0) {
                j = j + 1;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{15, 17, 19, 13, 22, 16, 28, 30, 41, 62};
//        System.out.println(Arrays.toString(nums));
//        sort(nums);
//        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                throw new IllegalArgumentException("ERROR");
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
