/**
 * @author huangxuewei
 * @since 2023/7/18
 */
public class Solution20230718 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution20230718 solution = new Solution20230718();

        ListNode head;
        int pos;

        head = ListNode.generateLinkedList(new int[]{3, 2, 0, -4});
        pos = 1;
        buildCycle(head, pos);
        System.out.println("result: " + solution.hasCycle(head));

        head = ListNode.generateLinkedList(new int[]{1, 2});
        pos = 0;
        buildCycle(head, pos);
        System.out.println("result: " + solution.hasCycle(head));

        head = ListNode.generateLinkedList(new int[]{1});
        System.out.println("result: " + solution.hasCycle(head));
    }

    private static void buildCycle(ListNode head, int pos) {
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }

        ListNode cur = head;
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        end.next = cur;
    }
}
