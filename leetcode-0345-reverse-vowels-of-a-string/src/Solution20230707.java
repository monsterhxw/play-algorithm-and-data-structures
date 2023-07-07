/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();

        int l = 0;
        int r = chs.length - 1;

        while (l < r) {
            while (l < r && isNotVowel(chs[l])) {
                l++;
            }
            while (l < r && isNotVowel(chs[r])) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(chs, l, r);
            l++;
            r--;
        }

        return new String(chs);
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    private boolean isNotVowel(char c) {
        return c != 'a' && c != 'A' &&
                c != 'e' && c != 'E' &&
                c != 'i' && c != 'I' &&
                c != 'o' && c != 'O' &&
                c != 'u' && c != 'U';
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();
        String s = "hello";
        System.out.println("s: " + s + ", result: " + solution.reverseVowels(s));

        System.out.println();
        s = "leetcode";
        System.out.println("s: " + s + ", result: " + solution.reverseVowels(s));
    }
}
