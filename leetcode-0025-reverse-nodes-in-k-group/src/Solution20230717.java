/**
 * @author huangxuewei
 * @since 2023/7/17
 */
public class Solution20230717 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode end = dummyHead;

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return dummyHead.next;
                } else {
                    end = end.next;
                }
            }
            ListNode start = pre.next;
            ListNode next = end.next;

            pre.next = reverseList(start, next);
            start.next = next;

            pre = start;
            end = start;
        }
        return dummyHead.next;
    }

    public ListNode reverseKGroupR(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            } else {
                tail = tail.next;
            }
        }
        ListNode newHead = reverseList(head, tail);
        head.next = reverseKGroupR(tail, k);
        return newHead;
    }

    private ListNode reverseList(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution20230717 solution = new Solution20230717();

        ListNode head;
        int k;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        k = 2;
        System.out.println("1: head: " + head + ", k: " + k + ", result: " + solution.reverseKGroup(head, k));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        k = 3;
        System.out.println("1: head: " + head + ", k: " + k + ", result: " + solution.reverseKGroup(head, k));

        System.out.println();

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        k = 2;
        System.out.println("2: head: " + head + ", k: " + k + ", result: " + solution.reverseKGroupR(head, k));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        k = 3;
        System.out.println("2: head: " + head + ", k: " + k + ", result: " + solution.reverseKGroupR(head, k));
    }
}
