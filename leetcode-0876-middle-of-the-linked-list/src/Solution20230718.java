/**
 * @author huangxuewei
 * @since 2023/7/18
 */
public class Solution20230718 {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution20230718 solution = new Solution20230718();

        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("head: " + head + ", result: " + solution.middleNode(head));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("head: " + head + ", result: " + solution.middleNode(head));
    }
}
