/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                next = cur.next;
                cur.next = next.next;
                next.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

        ListNode head;
        int[] nums;

        nums = new int[]{1, 1, 2};
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.deleteDuplicates(head));

        nums = new int[]{1, 1, 2, 3, 3};
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.deleteDuplicates(head));

        nums = new int[]{1, 1};
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.deleteDuplicates(head));

        nums = new int[]{1, 2};
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.deleteDuplicates(head));
    }
}
