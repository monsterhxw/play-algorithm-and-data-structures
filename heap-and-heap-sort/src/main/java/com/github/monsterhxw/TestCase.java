package com.github.monsterhxw;

import main.java.com.github.monsterhxw.heap.MaxHeap;
import main.java.com.github.monsterhxw.heapsort.HeapSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author XueweiHuang
 * @created 2022-03-22
 */
public class TestCase {
  public static void main(String[] args) {
    int n = 10;
    int[] arr = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      arr[i] = random.nextInt(100);
    }
    System.out.println(Arrays.toString(arr));
    System.out.println("========================");
    testMaxHeap(arr);
    System.out.println("========================");
    testSimpleHeapSort(arr);
    System.out.println("========================");
    testHeapifySort(arr);
    System.out.println("========================");
    testBuildHeapUsingHeapifyUp(arr);
    System.out.println("========================");
    testBuildHeapUsingHeapifyDown(arr);
    System.out.println("========================");
  }

  private static void testMaxHeap(int[] arr) {
    System.out.println("testMaxHeap");
    MaxHeap maxHeap = new MaxHeap(arr.length);
    for (int i : arr) {
      maxHeap.add(i);
    }
    System.out.println(maxHeap);
    System.out.println("========================");
    int size = maxHeap.size();
    System.out.printf("extract before: %s%n", maxHeap);
    for (int i = 0; i < size; i++) {
      int max = maxHeap.extractMax();
      System.out.printf("extract max: %d, ", max);
      System.out.println(maxHeap);
    }
  }

  private static void testSimpleHeapSort(int[] arr) {
    System.out.println("testSimpleHeapSort");
    System.out.println(Arrays.toString(arr));
    System.out.println("========================");
    int[] data = Arrays.copyOf(arr, arr.length);

    HeapSort.sort(data);
    System.out.println(Arrays.toString(data));
    validateSorted(data);
  }

  private static void testHeapifySort(int[] arr) {
    System.out.println("testHeapifySort");
    System.out.println(Arrays.toString(arr));
    System.out.println("========================");
    int[] data = Arrays.copyOf(arr, arr.length);
    HeapSort.sortUsingHeapifyDown(data);
    System.out.println(Arrays.toString(data));
    validateSorted(data);
  }

  private static void validateSorted(int[] data) {
    for (int i = 1; i < data.length; i++) {
      if (data[i - 1] > data[i]) {
        throw new RuntimeException("排序不正确");
      }
    }
  }

  private static void testBuildHeapUsingHeapifyUp(int[] arr) {
    System.out.println("testBuildHeapUsingHeapifyUp");
    System.out.println(Arrays.toString(arr));
    System.out.println("========================");
    int[] data = Arrays.copyOf(arr, arr.length);

    HeapSort.heapifyUp(data);
    System.out.println(Arrays.toString(data));
  }

  private static void testBuildHeapUsingHeapifyDown(int[] arr) {
    System.out.println("testBuildHeapUsingHeapifyDown");
    System.out.println(Arrays.toString(arr));
    System.out.println("========================");
    int[] data = Arrays.copyOf(arr, arr.length);

    HeapSort.heapifyDown(data);
    System.out.println(Arrays.toString(data));
  }
}
