/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && isNotLetterOrDigit(s, l)) {
                l++;
            }
            while (l < r && isNotLetterOrDigit(s, r)) {
                r--;
            }
            if (l >= r) {
                break;
            }
            char lChar = Character.toLowerCase(s.charAt(l));
            char rChar = Character.toLowerCase(s.charAt(r));
            if (lChar != rChar) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isNotLetterOrDigit(String s, int i) {
        return !Character.isLetterOrDigit(s.charAt(i));
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();

        String s = "A man, a plan, a canal: Panama";
        System.out.println("s: " + s + ", result: " + solution.isPalindrome(s) + ", actual: true");

        s = "race a car";
        System.out.println("s: " + s + ", result: " + solution.isPalindrome(s) + ", actual: false");

        s = " ";
        System.out.println("s: " + s + ", result: " + solution.isPalindrome(s) + ", actual: true");
    }
}
