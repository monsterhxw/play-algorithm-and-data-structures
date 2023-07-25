import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangxuewei
 * @since 2023/7/24
 */
public class Solution20230725 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curRes = new LinkedList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode cur = queue.poll();
                curRes.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(0, curRes);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution20230725 solution = new Solution20230725();

        TreeNode root;

        root = case1();
        System.out.println("result: " + solution.levelOrderBottom(root));

        root = case2();
        System.out.println("result: " + solution.levelOrderBottom(root));

        root = null;
        System.out.println("result: " + solution.levelOrderBottom(root));
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
