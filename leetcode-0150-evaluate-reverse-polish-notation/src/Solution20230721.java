import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author huangxuewei
 * @since 2023/7/21
 */
public class Solution20230721 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    default:
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Solution20230721 solution = new Solution20230721();

        String[] tokens;

        tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println("tokens: " + Arrays.toString(tokens) + ", result: " + solution.evalRPN(tokens));

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println("tokens: " + Arrays.toString(tokens) + ", result: " + solution.evalRPN(tokens));

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("tokens: " + Arrays.toString(tokens) + ", result: " + solution.evalRPN(tokens));
    }
}
