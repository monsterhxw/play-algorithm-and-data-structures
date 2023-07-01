package offer;

/**
 * @author huangxuewei
 * @since 2023/6/23
 */
public class Solution51 {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) {
            return 0;
        }
        int res = 0;
        int mid = l + ((r - l) / 2);
        res += mergeSort(arr, l, mid, temp);
        res += mergeSort(arr, mid + 1, r, temp);

        if (arr[mid] > arr[mid + 1]) {
            res += merge(arr, l, mid, r, temp);
        }
        return res;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] temp) {
        for (int i = l; i < r + 1; i++) {
            temp[i] = arr[i];
        }
        int res = 0;
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
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        int res = (new Solution51()).reversePairs(nums);
        System.out.println(res);
    }
}
