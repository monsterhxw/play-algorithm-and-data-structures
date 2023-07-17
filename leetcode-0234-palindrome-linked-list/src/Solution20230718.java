/**
 * @author huangxuewei
 * @since 2023/7/18
 */
public class Solution20230718 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode reverseRight = reverseList(slow);

        while (head != slow && reverseRight != null) {
            if (head.val == reverseRight.val) {
                head = head.next;
                reverseRight = reverseRight.next;
            } else {
                return false;
            }
        }

        return true;
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

    public static void main(String[] args) {
        Solution20230718 solution = new Solution20230718();

        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 2, 1});
        System.out.println("head: " + head + ", result: " + solution.isPalindrome(head));

        head = ListNode.generateLinkedList(new int[]{1, 2});
        System.out.println("head: " + head + ", result: " + solution.isPalindrome(head));

        head = ListNode.generateLinkedList(new int[]{1, 2, 2, 2, 1});
        System.out.println("head: " + head + ", result: " + solution.isPalindrome(head));
    }
}
