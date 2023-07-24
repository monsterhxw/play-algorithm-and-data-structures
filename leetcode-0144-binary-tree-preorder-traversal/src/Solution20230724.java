import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/24
 */
public class Solution20230724 {

    public List<Integer> preorderTraversalR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalR(root, res);
        return res;
    }

    private void preorderTraversalR(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversalR(root.left, res);
        preorderTraversalR(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20230724 solution = new Solution20230724();

        TreeNode root;

        root = case1();
        System.out.println("result: " + solution.preorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = null;
        System.out.println("result: " + solution.preorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = case2();
        System.out.println("result: " + solution.preorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = case3();
        System.out.println("result: " + solution.preorderTraversalR(root));
        System.out.println("result: " + solution.preorderTraversal(root));

        root = case4();
        System.out.println("result: " + solution.preorderTraversalR(root));
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
