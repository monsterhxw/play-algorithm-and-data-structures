package com.github.monsterhxw.heapsort;

import com.github.monsterhxw.heap.MaxHeap;

/**
 * @author XueweiHuang
 * @created 2022-03-23
 */
public class HeapSort {

  /** time complexity: O(nlogn) */
  public static void sort(int[] data) {
    if (data.length <= 1) {
      return;
    }
    // 构建最大堆
    MaxHeap maxHeap = new MaxHeap(data.length);
    // 循环插入数据 time complexity: O(nlogn)
    for (int i = 0; i < data.length; i++) {
      maxHeap.add(data[i]);
    }
    // 循环取出最大的元素 O(nlogn)
    for (int i = data.length - 1; i >= 0; i--) {
      data[i] = maxHeap.extractMax();
    }
  }

  /** time complexity: O(nlogn) */
  public static void sortUsingHeapifyDown(int[] data) {
    // 构建最大堆, time complexity: O(n)
    heapifyDown(data);
    // 循环数组，向前依次执行向下调整，time complexity: O(nlogn)
    for (int i = data.length - 1; i >= 0; i--) {
      swap(data, 0, i);
      siftDown(data, 0, i);
    }
  }

  /** time complexity: O(n) */
  public static void heapifyDown(int[] data) {
    // 从最后一个非叶子节点，循环，开始向下调整
    int lastNonLeafNodeIndex = ((data.length - 1) - 1) / 2;
    for (int i = lastNonLeafNodeIndex; i >= 0; i--) {
      siftDown(data, i, data.length);
    }
  }

  private static void siftDown(int[] data, int index, int len) {
    // 有左孩子节点才进行向下调整
    while (index * 2 + 1 < len) {
      int max = index * 2 + 1;
      // 判断是否有右孩子节点，并且右孩子节点比左孩子节点大，最大值索引设为右孩子节点索引
      if (max + 1 < len && data[max] < data[max + 1]) {
        max = index * 2 + 2;
      }
      // 如果左右孩子节点小于等于当前节点，无需再向下调整
      if (data[max] <= data[index]) {
        break;
      }
      // 如果左右孩子节点中的最大值大于当前节点，交换最大值和当前节点值，并继续向下调整
      swap(data, index, max);
      index = max;
    }
  }

  /** time complexity: O(nlogn) */
  public static void heapifyUp(int[] arr) {
    // 从根结点开始，按 BFS 序进行向上调整 sift up
    for (int i = 0; i < arr.length; i++) {
      siftUp(arr, i);
    }
  }

  private static void siftUp(int[] arr, int index) {
    // 非根节点和当前节点值大于父节点值，才向上调整
    while (index > 0 && arr[index] > arr[(index - 1) / 2]) {
      // 交换当前节点和父节点
      swap(arr, index, (index - 1) / 2);
      // 继续向上调整
      index = (index - 1) / 2;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
