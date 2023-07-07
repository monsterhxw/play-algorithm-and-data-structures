import java.util.ArrayList;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/8
 */
public class Solution20230708 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] cntS = new int[26];
        int[] cntP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            cntP[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            cntS[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) {
                cntS[s.charAt(l) - 'a']--;
                l++;
            }
            if (equals(cntP, cntS)) {
                res.add(l);
            }
            r++;
        }

        return res;
    }

    private boolean equals(int[] first, int[] second) {
        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] cnt = new int[26];
        int pWords = 0;

        for (int i = 0; i < p.length(); i++) {
            if (++cnt[p.charAt(i) - 'a'] == 1) {
                pWords++;
            }
        }

        int containWords = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            if (--cnt[s.charAt(r) - 'a'] == 0) {
                containWords++;
            }
            if (r - l + 1 > p.length()) {
                if (++cnt[s.charAt(l) - 'a'] == 1) {
                    containWords--;
                }
                l++;
            }
            if (pWords == containWords) {
                res.add(l);
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution20230708 solution = new Solution20230708();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("1. s: " + s + ", p: " + p + ", result: " + solution.findAnagrams(s, p));
        s = "abab";
        p = "ab";
        System.out.println("1. s: " + s + ", p: " + p + ", result: " + solution.findAnagrams(s, p));

        System.out.println();
        s = "cbaebabacd";
        p = "abc";
        System.out.println("2. s: " + s + ", p: " + p + ", result: " + solution.findAnagrams2(s, p));
        s = "abab";
        p = "ab";
        System.out.println("2. s: " + s + ", p: " + p + ", result: " + solution.findAnagrams2(s, p));
    }
}
