package heap;

import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/27
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        heapify();
    }

    private void heapify() {
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            int parent = parent(k);
            data.swap(k, parent);
            k = parent;
        }
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            if (j + 1 < size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                // data[j] 是 leftChild 和 rightChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);
        siftDown(0);

        return ret;
    }


    private void sout() {
        System.out.println(data);
    }

    public static void main(String[] args) {
//        Integer[] nums = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15};
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(11);
//        for (int i = 0; i < nums.length; i++) {
//            maxHeap.add(nums[i]);
//        }
//        maxHeap.sout();
//
//        maxHeap.add(52);
//        maxHeap.sout();
//
//        System.out.println("extract max: " + maxHeap.extractMax());
//        maxHeap.sout();

        int n = 1_000_000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("ERROR");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }
}
