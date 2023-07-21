import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangxuewei
 * @since 2023/7/21
 */
public class Solution20230721 {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] names = path.split("/");

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name.isEmpty() || name.equals(".")) {
                continue;
            } else if (name.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else {
                deque.push(name);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append("/").append(deque.pollLast());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution20230721 solution = new Solution20230721();

        String path;

        path = "/home/";
        System.out.println("path: " + path + ", result: " + solution.simplifyPath(path));

        path = "/../";
        System.out.println("path: " + path + ", result: " + solution.simplifyPath(path));

        path = "/home//foo/";
        System.out.println("path: " + path + ", result: " + solution.simplifyPath(path));

        path = "/a/./b/../../c/";
        System.out.println("path: " + path + ", result: " + solution.simplifyPath(path));
    }
}
