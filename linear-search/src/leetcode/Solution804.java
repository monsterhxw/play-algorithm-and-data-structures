package leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author huangxuewei
 * @since 2023/6/27
 */
public class Solution804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                int index = c - 'a';
                res.append(codes[index]);
            }
            set.add(res.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int res = (new Solution804()).uniqueMorseRepresentations(words);
        System.out.println(res);
    }
}
