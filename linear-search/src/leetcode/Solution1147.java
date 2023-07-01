package leetcode;

/**
 * @author huangxuewei
 * @since 2023/7/2
 */
public class Solution1147 {

    public int longestDecomposition(String text) {
        return solve(text, 0, text.length() - 1);
    }

    // s[left, right]
    private int solve(String s, int left, int right) {
        if (left > right) {
            return 0;
        }

        for (int i = left, j = right; i < j; i++, j--) {
            // s[left,i] == s[j,right]
            if (equal(s, left, i, j, right)) {
                return 2 + solve(s, i + 1, j - 1);
            }
        }
        return 1;
    }

    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private final long MOD = (long) (1e9 + 7);

    private long[] pow26;

    public int longestDecomposition2(String text) {
        // pow26[i] = 26^i;
        pow26 = new long[text.length()];
        pow26[0] = 1;
        for (int i = 1; i < text.length(); i++) {
            pow26[i] = (pow26[i - 1] * 26) % MOD;
        }
        return solve2(text, 0, text.length() - 1);
    }

    // s[left, right]
    private int solve2(String s, int left, int right) {
        if (left > right) {
            return 0;
        }

        long prehash = 0;
        long posthash = 0;

        for (int i = left, j = right; i < j; i++, j--) {

            prehash = (prehash * 26 + (s.charAt(i) - 'a')) % MOD;
            posthash = ((s.charAt(j) - 'a') * pow26[right - j] + posthash) % MOD;

            if (prehash == posthash && equal(s, left, i, j, right)) {
                // s[left,i] == s[j,right]
                return 2 + solve2(s, i + 1, j - 1);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int i = (new Solution1147()).longestDecomposition("volvo");
        System.out.println(i);
        i = (new Solution1147()).longestDecomposition2("volvo");
        System.out.println(i);
    }

}
