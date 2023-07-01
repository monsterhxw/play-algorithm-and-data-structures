package set;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangxuewei
 * @since 2023/6/25
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else { // e > node.e
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        System.out.print("pre order: ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderIteration() {
        System.out.print("pre order using iteration: ");

        Deque<Node> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.e + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        System.out.println();
    }

    public void inOrder() {
        System.out.print("in order: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        System.out.print("post order: ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        String depthStr = generateDepthString(depth);
        if (node == null) {
            res.append(depthStr).append("null").append("\n");
            return;
        }
        res.append(depthStr).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public void breadthFirstSearch() {
        System.out.print("BFS: ");
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.e + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        System.out.println();
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node minimum = minimum(root);
        return minimum.e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node maximum = maximum(root);
        return maximum.e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e == node.e
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else { // node.left != null && node.right != null
                // 待删除节点左右子树都不为空的情况
                // 找到比待删除 node 大的最小 node，即待删除 node 的 right child tree 的最小 node (successor, 后继者)
                // 用 successor 顶替待删除 node 的位置
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right); // removeMin 会 size--
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        System.out.println("get size: " + bst.getSize());
        System.out.println("contains: " + bst.contains(4));
        bst.preOrder();
        bst.preOrderIteration();
        bst.inOrder();
        bst.postOrder();

        bst.breadthFirstSearch();

//        System.out.println(bst);
        System.out.println();
        System.out.println("get size: " + bst.getSize() + ", minimum: " + bst.minimum());
        System.out.println("remove minimum: " + bst.removeMin());
        System.out.println("get size: " + bst.getSize() + ", minimum: " + bst.minimum());
        System.out.println();
        System.out.println("get size: " + bst.getSize() + ", maximum: " + bst.maximum());
        System.out.println("remove maximum: " + bst.removeMax());
        System.out.println("get size: " + bst.getSize() + ", maximum: " + bst.maximum());
    }
}
