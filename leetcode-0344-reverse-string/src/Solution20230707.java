import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();

        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println("Array: " + Arrays.toString(s));
        solution.reverseString(s);
        System.out.println("Result: " + Arrays.toString(s));

        System.out.println();
        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println("Array: " + Arrays.toString(s));
        solution.reverseString(s);
        System.out.println("Result: " + Arrays.toString(s));
    }
}
