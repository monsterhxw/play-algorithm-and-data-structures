package com.github.hxw;

/**
 * @author XueweiHuang
 * @created 2021-12-21
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // arr[0...i) 是有序的; arr[i...n) 是无序的; 循环不变量
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n) 中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int index1, int index2) {
        E tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
