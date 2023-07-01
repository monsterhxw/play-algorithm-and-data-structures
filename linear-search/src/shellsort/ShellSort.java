package shellsort;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/28
 */
public class ShellSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;
        while (h >= 1) {
            for (int start = 0; start < h; start++) {
                // 对 data[start, start + h, start + 2h, start + 3h, ...]，进行插入排序
                for (int i = start + h; i < data.length; i = i + h) {
                    E temp = data[i];
                    int j;
                    for (j = i; j - h >= 0 && temp.compareTo(data[j - h]) < 0; j = j - h) {
                        data[j] = data[j - h];
                    }
                    data[j] = temp;
                }
            }
            h = h / 2;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 2, 4, 6, 1, 5};
        sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
