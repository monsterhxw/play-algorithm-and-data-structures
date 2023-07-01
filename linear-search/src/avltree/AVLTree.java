package avltree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/29
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            height = 1;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + ", left=" + left + ", right=" + right + ", height=" + height + '}';
        }
    }

    public AVLTree() {
        root = null;
        size = 0;
    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isBST() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i).compareTo(keys.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        boolean isLeftBalance = isBalance(node.left);
        boolean isRightBalance = isBalance(node.right);

        return isLeftBalance && isRightBalance;
    }

    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else { // key == node.key
            node.value = value;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

        // node->left->left=newNode
        // LL
        // right rotate (顺时针)
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // node->right->right=newNode
        // RR
        // left rotate (逆时针)
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // node->left->right=newNode
        // LR
        // 1. left rotate (逆时针) 2. right rotate (顺时针)
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // LR -> LL
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // node->right->left=newNode
        // RL
        // 1. right rotate (顺时针) 2. left rotate (逆时针)
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            // RL -> RR
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }

        root = remove(root, key);

        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else { // key == node.key
            if (node.left == null) {
                Node rightChild = node.right;
                node.right = null;
                size--;
                retNode = rightChild;
            } else if (node.right == null) {
                Node leftChild = node.left;
                node.left = null;
                size--;
                retNode = leftChild;
            } else { // node.left != null && node.right != null
                Node successor = minimum(node.right);

                // node.right = removeMin(node.right);
                node.right = remove(node.right, successor.key);

                successor.right = node.right;
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }
        }

        if (retNode == null) {
            return null;
        }

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        int balanceFactor = getBalanceFactor(retNode);

        // retNode->left->left=newNode
        // LL
        // right rotate (顺时针)
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }

        // retNode->right->right=newNode
        // RR
        // left rotate (逆时针)
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        // retNode->left->right=newNode
        // LR
        // 1. left rotate (逆时针) 2. right rotate (顺时针)
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            // LR -> LL
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // retNode->right->left=newNode
        // RL
        // 1. right rotate (顺时针) 2. left rotate (逆时针)
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            // RL -> RR
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public V minimum() {
        Node min = minimum(root);
        return min == null ? null : min.value;
    }

    public V removeMin() {
        Node min = minimum(root);
        if (min != null) {
            root = removeMin(root);
            return min.value;
        }
        return null;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightChild = node.right;
            node.right = null;
            size--;
            return rightChild;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public static void main(String[] args) {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        Random random = new Random();
//        int n = 1_000;
        int n = 5;
        for (int i = 0; i < n; i++) {
//            Integer j = i + random.nextInt(Integer.MAX_VALUE);
//            avlTree.add(j, j);
            avlTree.add(i, i);
        }
        System.out.println("is BST: " + avlTree.isBST());
        System.out.println("is balance: " + avlTree.isBalance());
        System.out.println("remove 1: " + avlTree.remove(1));
        System.out.println("is balance: " + avlTree.isBalance());
        System.out.println("is BST: " + avlTree.isBST());
    }
}
