import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/24
 */
public class Solution20230724 {

    public List<Integer> postorderTraversalR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalR(root, res);
        return res;
    }

    private void postorderTraversalR(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversalR(root.left, res);
        postorderTraversalR(root.right, res);
        res.add(root.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution20230724 solution = new Solution20230724();

        TreeNode root;

        root = case1();
        System.out.println("result: " + solution.postorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = null;
        System.out.println("result: " + solution.postorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = case2();
        System.out.println("result: " + solution.postorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = case3();
        System.out.println("result: " + solution.postorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = case4();
        System.out.println("result: " + solution.postorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));
    }

    private static TreeNode case1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    private static TreeNode case2() {
        TreeNode root = new TreeNode(1);
        return root;
    }

    private static TreeNode case3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }

    private static TreeNode case4() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        return root;
    }
}
