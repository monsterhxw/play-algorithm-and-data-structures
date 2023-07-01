package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/23
 */
public class QuickSort2 {

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
        // arr[l+1,j] < v;
        // arr[j+1,i] >= v;

        int p = l + RANDOM.nextInt(r - l + 1);
        swap(arr, l, p);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[l]) {
                swap(arr, j + 1, i);
                j++;
            }
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
