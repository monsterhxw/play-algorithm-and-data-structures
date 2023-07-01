package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/23
 */
public class QuickSort4 {

    private static Random RANDOM = new Random();

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = RANDOM.nextInt(r - l + 1);
        int v = arr[l];

        // 三路快速排序

        // arr[l+1,lt] < v, arr[lt+1,i - 1] = v, arr[gt,r] > v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i] < v) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i] > v) {
                gt--;
                swap(arr, i, gt);
            } else { // arr[i] = v
                i++;
            }
        }
        swap(arr, l, lt);

        // arr[l+1,lt-1] < v, arr[lt,gt-1] = v, arr[gt,r] > v
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 2, 3, 8, 7, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
