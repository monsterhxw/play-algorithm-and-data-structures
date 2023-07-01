package mergesort;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/23
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[l + i];
        }

        int i = l;
        int j = mid + 1;

        for (int k = l; k < r + 1; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] <= temp[j - l]) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void mergeSort2(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort2(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort2(int[] arr, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort2(arr, l, mid, temp);
        mergeSort2(arr, mid + 1, r, temp);

        if (arr[mid] > arr[mid + 1]) {
            merge2(arr, l, mid, r, temp);
        }
    }

    public static void mergeSortBottomUp(int[] arr) {
        int[] temp = new int[arr.length];

        int n = arr.length;
        for (int size = 1; size < n; size += size) {
            for (int i = 0; i + size < n; i += (size + size)) {
                int mid = i + size - 1;
                int r = Math.min((i + size + size - 1), (n - 1));
                if (arr[mid] > arr[mid + 1]) {
                    merge2(arr, i, mid, r, temp);
                }
            }
        }
    }

    private static void merge2(int[] arr, int l, int mid, int r, int[] temp) {
        for (int i = l; i < r + 1; i++) {
            temp[i] = arr[i];
        }
        int i = l;
        int j = mid + 1;
        for (int k = l; k < r + 1; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 2, 4};
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 3, 6, 2, 4};
        mergeSort2(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 3, 6, 2, 4};
        mergeSortBottomUp(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
