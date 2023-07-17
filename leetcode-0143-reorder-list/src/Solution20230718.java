/**
 * @author huangxuewei
 * @since 2023/7/18
 */
public class Solution20230718 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);

        ListNode right = reverseList(mid.next);

        ListNode left = head;
        mid.next = null;

        mergeList(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private void mergeList(ListNode left, ListNode right) {
        while (left != null && right != null) {
            ListNode leftNext = left.next;
            left.next = right;
            left = leftNext;

            ListNode rightNext = right.next;
            right.next = left;
            right = rightNext;
        }
    }

    public static void main(String[] args) {
        Solution20230718 solution = new Solution20230718();

        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4});
        System.out.print("head: " + head + ", result: ");
        solution.reorderList(head);
        System.out.println(head);

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.print("head: " + head + ", result: ");
        solution.reorderList(head);
        System.out.println(head);
    }
}
