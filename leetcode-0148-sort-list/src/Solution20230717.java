/**
 * @author huangxuewei
 * @since 2023/7/17
 */
public class Solution20230717 {

    public ListNode sortList2(ListNode head) {
        return mergeSortListUpToBottom(head);
    }

    private ListNode mergeSortListUpToBottom(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midNext = slow.next;
        slow.next = null;

        ListNode left = mergeSortListUpToBottom(head);
        ListNode right = mergeSortListUpToBottom(midNext);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if (left != null) {
            pre.next = left;
        }
        if (right != null) {
            pre.next = right;
        }
        return dummyHead.next;
    }

    public ListNode sortList1(ListNode head) {
        return insertionSortList(head);
    }

    private ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummyHead;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230717 solution = new Solution20230717();

        ListNode head;

        head = ListNode.generateLinkedList(new int[]{4, 2, 1, 3});
        System.out.println("1: head: " + head + ", result: " + solution.sortList1(head));

        head = ListNode.generateLinkedList(new int[]{-1, 5, 3, 4, 0});
        System.out.println("1: head: " + head + ", result: " + solution.sortList1(head));

        head = ListNode.generateLinkedList(new int[]{3, 2, 4, 6, 5, 1, 7, 8});
        System.out.println("2: head: " + head + ", result: " + solution.sortList2(head));

        head = ListNode.generateLinkedList(new int[]{4, 2, 1, 3});
        System.out.println("2: head: " + head + ", result: " + solution.sortList2(head));

        head = ListNode.generateLinkedList(new int[]{-1, 5, 3, 4, 0});
        System.out.println("2: head: " + head + ", result: " + solution.sortList2(head));
    }
}
