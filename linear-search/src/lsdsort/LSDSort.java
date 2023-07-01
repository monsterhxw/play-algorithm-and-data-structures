package lsdsort;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/1
 */
public class LSDSort {

    public static void sort(String[] arr, int width) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() != width) {
                throw new IllegalArgumentException("All Strings' length must be the same.");
            }
        }

        int R = 256;

        int[] cnt = new int[R];

        int[] index = new int[R + 1];

        String[] temp = new String[arr.length];

        for (int r = width - 1; r >= 0; r--) {

            Arrays.fill(cnt, 0);
            for (String s : arr) {
                cnt[s.charAt(r)]++;
            }

            for (int i = 0; i < R; i++) {
                index[i + 1] = index[i] + cnt[i];
            }

            for (String s : arr) {
                temp[index[s.charAt(r)]] = s;
                index[s.charAt(r)]++;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"BCA", "CAB", "ACB", "BAC", "ABC", "CBA"};
        sort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
