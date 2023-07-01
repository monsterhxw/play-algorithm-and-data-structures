package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/23
 */
public class QuickSort3 {

    private static Random RANDOM = new Random();

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);

        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int p = l + RANDOM.nextInt(r - l + 1);
        swap(arr, l, p);

        int v = arr[l];

        // 双路快速排序

        // arr[l+1,i-1] <= v;
        // arr[j+1,r] > v;
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i] < v) {
                i++;
            }
            while (j >= i && arr[j] > v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
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
