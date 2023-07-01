package substringmatch;

/**
 * @author huangxuewei
 * @since 2023/7/2
 */
public class SubstringMatch {

    public static int bruteforce(String s, String t) {
        if (s.length() < t.length()) {
            return -1;
        }

        // s[i, i+t.length-1] == t?
        for (int i = 0; i + t.length() - 1 < s.length(); i++) {
            int j = 0;
            for (; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "hello, this is liuyubobobo.";
        String t = "bo";
        int index = bruteforce(s, t);
        System.out.println(index);
    }
}
