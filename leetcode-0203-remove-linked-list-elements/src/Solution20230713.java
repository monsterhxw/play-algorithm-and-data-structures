/**
 * @author huangxuewei
 * @since 2023/7/14
 */
public class Solution20230713 {

    public ListNode removeElementsR(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode next = removeElementsR(head.next, val);
        head.next = next;
        return head.val == val ? next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

        int val;
        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 6, 3, 4, 5, 6});
        val = 6;
        System.out.println("1: head: " + head + ", val: " + val + ", result: " + solution.removeElements(head, val));

        head = ListNode.generateLinkedList(new int[]{});
        val = 1;
        System.out.println("1: head: " + head + ", val: " + val + ", result: " + solution.removeElements(head, val));

        head = ListNode.generateLinkedList(new int[]{7, 7, 7, 7});
        val = 7;
        System.out.println("1: head: " + head + ", val: " + val + ", result: " + solution.removeElements(head, val));

        System.out.println();
        head = ListNode.generateLinkedList(new int[]{1, 2, 6, 3, 4, 5, 6});
        val = 6;
        System.out.println("2: head: " + head + ", val: " + val + ", result: " + solution.removeElementsR(head, val));

        head = ListNode.generateLinkedList(new int[]{});
        val = 1;
        System.out.println("2: head: " + head + ", val: " + val + ", result: " + solution.removeElementsR(head, val));

        head = ListNode.generateLinkedList(new int[]{7, 7, 7, 7});
        val = 7;
        System.out.println("2: head: " + head + ", val: " + val + ", result: " + solution.removeElementsR(head, val));
    }
}
