import java.util.HashMap;
import java.util.Map;

/**
 * @author huangxuewei
 * @since 2023/7/19
 */
public class LRUCache20230719 {

    class Node {
        private int key;
        private int value;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private Map<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache20230719(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            // 追加头部
            addToHead(newNode);
            if (map.size() > capacity) {
                Node lruEnd = evictTail();
                map.remove(lruEnd.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private Node evictTail() {
        Node lruEnd = tail.prev;
        remove(lruEnd);
        return lruEnd;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private void moveToHead(Node node) {
        if (node.prev == head) {
            return;
        }
        remove(node);
        addToHead(node);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('{');
        Node cur = head.next;
        for (int i = 0; i < map.size(); i++) {
            res.append(cur.key).append('=').append(cur.value);
            if (i < map.size() - 1) {
                res.append(", ");
            }
            cur = cur.next;
        }
        res.append('}');
        return res.toString();
    }

    public static void main(String[] args) {
        LRUCache20230719 lRUCache = new LRUCache20230719(2);

        int value;

        lRUCache.put(1, 1); // 缓存是 {1=1}
        System.out.print("put(1, 1): " + lRUCache);
        System.out.println(", 缓存是 {1=1}");

        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.print("put(2, 2): " + lRUCache);
        System.out.println(", 缓存是 {1=1, 2=2}");

        value = lRUCache.get(1);// 返回 1
        System.out.print("get(1): " + value);
        System.out.println(", " + lRUCache);

        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.print("put(3, 3): " + lRUCache);
        System.out.println(", 缓存是 {1=1, 3=3}");

        value = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.print("get(2): " + value);
        System.out.println(", " + lRUCache);

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.print("put(4, 4): " + lRUCache);
        System.out.println(", 缓存是 {4=4, 3=3}");

        value = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.print("get(1): " + value);
        System.out.println(", " + lRUCache);

        value = lRUCache.get(3);    // 返回 3
        System.out.print("get(3): " + value);
        System.out.println(", " + lRUCache);

        value = lRUCache.get(4);    // 返回 4
        System.out.print("get(4): " + value);
        System.out.println(", " + lRUCache);
    }
}
