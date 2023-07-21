import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangxuewei
 * @since 2023/7/21
 */
public class Solution20230721 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty() || !stack.pop().equals('(')) {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || !stack.pop().equals('{')) {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || !stack.pop().equals('[')) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20230721 solution = new Solution20230721();
        String s;

        s = "()";
        System.out.println("s: " + s + ", result: " + solution.isValid(s));

        s = "()[]{}";
        System.out.println("s: " + s + ", result: " + solution.isValid(s));

        s = "(]";
        System.out.println("s: " + s + ", result: " + solution.isValid(s));
    }
}
