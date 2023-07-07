import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/8
 */
public class Solution20230708 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int start = 0;
        int len = s.length() + 1;

        int[] cntT = new int[128];
        int tWords = 0;
        for (int i = 0; i < t.length(); i++) {
            if (++cntT[t.charAt(i)] == 1) {
                tWords++;
            }
        }

        int[] cntS = new int[128];
        int sWords = 0;

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char rCh = s.charAt(r);
            if (cntT[rCh] > 0) {
                cntS[rCh]++;
                if (cntS[rCh] == cntT[rCh]) {
                    sWords++;
                }
            }

            while (tWords == sWords) {
                if (r - l + 1 < len) {
                    start = l;
                    len = r - l + 1;
                }
                char lCh = s.charAt(l);
                if (cntT[lCh] > 0) {
                    if (cntS[lCh] == cntT[lCh]) {
                        sWords--;
                    }
                    cntS[lCh]--;
                }
                l++;
            }

            r++;
        }

        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Solution20230708 solution = new Solution20230708();

        String s, t, actual, result;

        s = "ADOBECODEBANC";
        t = "ABC";
        actual = "BANC";
        result = solution.minWindow(s, t);
        System.out.println("s: " + s + ", t: " + t + ", result: " + result + ", actual: " + actual);

        s = "a";
        t = "a";
        actual = "a";
        result = solution.minWindow(s, t);
        System.out.println("s: " + s + ", t: " + t + ", result: " + result + ", actual: " + actual);

        s = "a";
        t = "aa";
        actual = "";
        result = solution.minWindow(s, t);
        System.out.println("s: " + s + ", t: " + t + ", result: " + result + ", actual: " + actual);
    }
}
