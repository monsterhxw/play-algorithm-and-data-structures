import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangxuewei
 * @since 2023/7/24
 */
public class Solution20230725 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (isOrderLeft) {
                    level.add(0, cur.val);
                } else {
                    level.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
            isOrderLeft = !isOrderLeft;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution20230725 solution = new Solution20230725();

        TreeNode root;

        root = case1();
        System.out.println("result: " + solution.zigzagLevelOrder(root));

        root = case2();
        System.out.println("result: " + solution.zigzagLevelOrder(root));

        root = null;
        System.out.println("result: " + solution.zigzagLevelOrder(root));
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
