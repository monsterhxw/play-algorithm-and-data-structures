import java.util.*;

/**
 * @author huangxuewei
 * @since 2023/7/12
 */
public class Solution20230712 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String code = encode(strs[i]);
            List<String> val = map.getOrDefault(code, new ArrayList<>());
            val.add(strs[i]);
            map.put(code, val);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String str) {
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                char ch = (char) ('a' + i);
                sb.append(ch);
                sb.append(cnt[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution20230712 solution = new Solution20230712();

        String[] strs;

        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("strs: " + Arrays.toString(strs) + ", result: " + solution.groupAnagrams(strs));

//        strs = new String[]{""};
//        System.out.println("strs: " + Arrays.toString(strs) + ", result: " + solution.groupAnagrams(strs));
//
//        strs = new String[]{"a"};
//        System.out.println("strs: " + Arrays.toString(strs) + ", result: " + solution.groupAnagrams(strs));
    }
}
