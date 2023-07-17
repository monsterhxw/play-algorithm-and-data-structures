/**
 * @author huangxuewei
 * @since 2023/7/17
 */
public class Solution20230717 {

    public ListNode insertionSortList(ListNode head) {
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
        System.out.println("head: " + head + ", result: " + solution.insertionSortList(head));

        head = ListNode.generateLinkedList(new int[]{-1, 5, 3, 4, 0});
        System.out.println("head: " + head + ", result: " + solution.insertionSortList(head));
    }
}
