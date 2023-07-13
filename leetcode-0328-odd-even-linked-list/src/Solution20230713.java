/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

        ListNode head;
        int[] nums;

        nums = new int[]{1, 2, 3, 4, 5};
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.oddEvenList(head));

        nums = new int[]{2, 1, 3, 5, 6, 4, 7};
        head = ListNode.generateLinkedList(nums);
        System.out.println("head: " + head + ", result: " + solution.oddEvenList(head));
    }
}
