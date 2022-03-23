package com.github.monsterhxw.heap;

/**
 * @author XueweiHuang
 * @created 2022-03-23
 */
public class MaxHeap {

  private int[] data;

  private int size;

  public MaxHeap(int capacity) {
    this.data = new int[capacity];
    this.size = 0;
  }

  public void add(int e) {
    data[size] = e;
    siftUp(data, size);
    size++;
  }

  public int extractMax() {
    int result = data[0];
    data[0] = data[size - 1];
    data[size - 1] = Integer.MIN_VALUE;
    size--;
    siftDown(data, 0, size);
    return result;
  }

  public int replace(int e) {
    int result = data[0];

    data[0] = e;

    siftDown(data, 0, size);

    return result;
  }

  public int size() {
    return size;
  }

  private void siftUp(int[] arr, int index) {
    while (index > 0 && arr[index] > arr[parentIdx(index)]) {
      swap(arr, index, parentIdx(index));
      index = parentIdx(index);
    }
  }

  private void siftDown(int[] arr, int index, int len) {
    while (leftChildIdx(index) < len) {
      int max = leftChildIdx(index);
      if (max + 1 < len && arr[max] < arr[max + 1]) {
        max = rightChildIdx(index);
      }
      if (arr[max] <= arr[index]) {
        break;
      }
      swap(arr, index, max);
      index = max;
    }
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private int parentIdx(int index) {
    return (index - 1) / 2;
  }

  private int leftChildIdx(int index) {
    return 2 * index + 1;
  }

  private int rightChildIdx(int index) {
    return 2 * index + 2;
  }

  @Override
  public String toString() {
    if (this.data == null) {
      return "null";
    }
    int iMax = this.size - 1;
    if (iMax == -1) {
      return "[]";
    }

    StringBuilder b = new StringBuilder();
    b.append('[');
    for (int i = 0; ; i++) {
      b.append(this.data[i]);
      if (i == iMax) {
        return b.append(']').toString();
      }
      b.append(", ");
    }
  }
}
