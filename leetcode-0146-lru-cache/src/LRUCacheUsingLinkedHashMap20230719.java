import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangxuewei
 * @since 2023/7/19
 */
public class LRUCacheUsingLinkedHashMap20230719 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheUsingLinkedHashMap20230719(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap20230719 lRUCache = new LRUCacheUsingLinkedHashMap20230719(2);

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
