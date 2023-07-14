/**
 * @author huangxuewei
 * @since 2023/7/14
 */
public class Solution20230714 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230714 solution = new Solution20230714();
        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println("head: " + head + ", result: " + solution.deleteDuplicates(head));

        head = ListNode.generateLinkedList(new int[]{1, 1, 1, 2, 3});
        System.out.println("head: " + head + ", result: " + solution.deleteDuplicates(head));
    }
}
