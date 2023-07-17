/**
 * @author huangxuewei
 * @since 2023/7/17
 */
public class Solution20230717 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        ListNode tail = head;
        for (int i = 0; i < n && tail != null; i++) {
            tail = tail.next;
        }

        while (tail != null) {
            pre = pre.next;
            tail = tail.next;
        }

        pre.next = pre.next.next;

        return dummyHead.next;
    }

    public ListNode removeNthFromEndR(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int cnt = backtracking(head, n);
        return cnt < n ? head.next : head;
    }

    private int backtracking(ListNode head, int n) {
        if (head.next == null) {
            return 0;
        }
        int cnt = backtracking(head.next, n) + 1;
        if (cnt == n) {
            head.next = head.next.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution20230717 solution = new Solution20230717();

        ListNode head;
        int n;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        n = 2;
        System.out.println("1: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEndR(head, n));

        head = ListNode.generateLinkedList(new int[]{1});
        n = 1;
        System.out.println("1: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEndR(head, n));

        head = ListNode.generateLinkedList(new int[]{1, 2});
        n = 1;
        System.out.println("1: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEndR(head, n));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3});
        n = 3;
        System.out.println("1: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEndR(head, n));

        System.out.println();
        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        n = 2;
        System.out.println("2: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEnd(head, n));

        head = ListNode.generateLinkedList(new int[]{1});
        n = 1;
        System.out.println("2: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEnd(head, n));

        head = ListNode.generateLinkedList(new int[]{1, 2});
        n = 1;
        System.out.println("2: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEnd(head, n));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3});
        n = 3;
        System.out.println("2: head: " + head + ", n: " + n + ", result: " + solution.removeNthFromEnd(head, n));

    }
}
