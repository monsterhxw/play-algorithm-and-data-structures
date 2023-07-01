package leetcode;

import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/6/30
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        int ret = -1;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (freq[index] == 1) {
                return i;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(s + " : result is: " + (new Solution387()).firstUniqChar(s) + ", answer: " + "0 ");
        s = "loveleetcode";
        System.out.println(s + " : result is: " + (new Solution387()).firstUniqChar(s) + ", answer: " + "2 ");
        s = "aabb";
        System.out.println(s + " : result is: " + (new Solution387()).firstUniqChar(s) + ", answer: " + "-1 ");
    }
}
