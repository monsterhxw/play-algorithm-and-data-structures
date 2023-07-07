/**
 * @author huangxuewei
 * @since 2023/7/8
 */
public class Solution20230708 {

    public int lengthOfLongestSubstring(String s) {
        int ret = 0;

        int[] freq = new int[256];
        int l = 0;
        int r = -1;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            ret = Math.max(ret, r - l + 1);
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution20230708 solution = new Solution20230708();
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
