/**
 * @author huangxuewei
 * @since 2023/7/8
 */
public class Solution20230710 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] freq = new int[256];
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char rCh = s.charAt(r);
            freq[rCh]++;

            while (freq[rCh] > 1) {
                char lCh = s.charAt(l);
                freq[lCh]--;
                l++;
            }
            if (r - l + 1 > res) {
                res = r - l + 1;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20230710 solution = new Solution20230710();
        String s = "abcabcbb";
        System.out.println("s: " + s + ", result: " + solution.lengthOfLongestSubstring(s) + ", actual: 3");

        System.out.println();
        s = "bbbbb";
        System.out.println("s: " + s + ", result: " + solution.lengthOfLongestSubstring(s) + ", actual: 1");

        System.out.println();
        s = "pwwkew";
        System.out.println("s: " + s + ", result: " + solution.lengthOfLongestSubstring(s) + ", actual: 3");
    }
}
