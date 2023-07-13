/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummySmallHead = new ListNode(-1);
        ListNode preSmall = dummySmallHead;

        ListNode dummyLargeHead = new ListNode(-1);
        ListNode preLarge = dummyLargeHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                preSmall.next = cur;
                preSmall = preSmall.next;
            } else {
                preLarge.next = cur;
                preLarge = preLarge.next;
            }
            cur = cur.next;
        }

        preLarge.next = null;
        preSmall.next = dummyLargeHead.next;

        return dummySmallHead.next;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

        ListNode head;
        int[] nums;
        int x;

        nums = new int[]{1, 4, 3, 2, 5, 2};
        x = 3;
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.partition(head, x));

        nums = new int[]{1, 2};
        x = 2;
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.partition(head, x));
    }
}
