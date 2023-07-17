/**
 * @author huangxuewei
 * @since 2023/7/18
 */
public class Solution20230718 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode end = head;
        int sz = 1;
        while (end.next != null) {
            sz++;
            end = end.next;
        }

        k = k % sz;

        ListNode pre = dummyHead;
        for (int i = 0; i < sz - k; i++) {
            pre = pre.next;
        }

        end.next = dummyHead.next;
        dummyHead.next = pre.next;
        pre.next = null;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230718 solution = new Solution20230718();

        ListNode head;
        int k;

//        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
//        k = 2;
//        System.out.println("head: " + head + ", k: " + k + ", result: " + solution.rotateRight(head, k));

        head = ListNode.generateLinkedList(new int[]{0, 1, 2});
        k = 4;
        System.out.println("head: " + head + ", k: " + k + ", result: " + solution.rotateRight(head, k));
    }
}
