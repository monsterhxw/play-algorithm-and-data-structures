import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangxuewei
 * @since 2023/7/24
 */
public class Solution20230725 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode cur = queue.poll();
                if (i == curSize - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return res;
    }

    public List<Integer> rightSideViewR(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        rightFirstDFS(root, 0, res);
        return res;
    }

    private void rightFirstDFS(TreeNode node, int depth, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }
        rightFirstDFS(node.right, depth + 1, res);
        rightFirstDFS(node.left, depth + 1, res);
    }

    public static void main(String[] args) {
        Solution20230725 solution = new Solution20230725();

        TreeNode root;

        root = case1();
        System.out.println("R-result: " + solution.rightSideViewR(root));
        System.out.println("result: " + solution.rightSideView(root));

        root = case2();
        System.out.println("R-result: " + solution.rightSideViewR(root));
        System.out.println("result: " + solution.rightSideView(root));

        root = null;
        System.out.println("R-result: " + solution.rightSideViewR(root));
        System.out.println("result: " + solution.rightSideView(root));
    }

    private static TreeNode case1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        return root;
    }

    private static TreeNode case2() {
        TreeNode root = new TreeNode(1);
        return root;
    }
}
