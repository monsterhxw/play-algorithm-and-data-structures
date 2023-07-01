package leetcode;

/**
 * @author huangxuewei
 * @since 2023/6/25
 */
public class Solution875 {

    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int r = findMax(piles);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= H) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int findMax(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

    private int eatingTime(int[] piles, int k) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += piles[i] / k + (piles[i] % k > 0 ? 1 : 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int H = 8;
        int res = (new Solution875()).minEatingSpeed(piles, H);
        System.out.println(res);
    }
}
