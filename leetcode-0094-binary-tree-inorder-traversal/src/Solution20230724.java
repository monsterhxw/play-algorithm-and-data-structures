import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/24
 */
public class Solution20230724 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public static void main(String[] args) {
        Solution20230724 solution = new Solution20230724();

        TreeNode root;

        root = case1();
        System.out.println("result: " + solution.inorderTraversal(root));

        root = null;
        System.out.println("result: " + solution.inorderTraversal(root));

        root = case2();
        System.out.println("result: " + solution.inorderTraversal(root));

        root = case3();
        System.out.println("result: " + solution.inorderTraversal(root));

        root = case4();
        System.out.println("result: " + solution.inorderTraversal(root));
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
