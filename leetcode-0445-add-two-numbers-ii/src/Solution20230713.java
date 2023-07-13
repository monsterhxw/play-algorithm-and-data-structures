import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;

            ListNode newHead = new ListNode(sum % 10);
            newHead.next = head;
            head = newHead;

            carry = sum >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            head = new ListNode(1, head);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummyResHead = new ListNode(-1);
        ListNode pre = dummyResHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            pre.next = new ListNode(sum % 10);
            pre = pre.next;

            carry = sum >= 10 ? 1 : 0;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            pre.next = new ListNode(1);
        }

        return reverseList(dummyResHead.next);
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
        Solution20230713 solution = new Solution20230713();

        ListNode l1;
        ListNode l2;

        l1 = ListNode.generateLinkedList(new int[]{7, 2, 4, 3});
        l2 = ListNode.generateLinkedList(new int[]{5, 6, 4});
        System.out.println("1: l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers(l1, l2));

        l1 = ListNode.generateLinkedList(new int[]{2, 4, 3});
        l2 = ListNode.generateLinkedList(new int[]{5, 6, 4});
        System.out.println("1: l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers(l1, l2));

        l1 = ListNode.generateLinkedList(new int[]{0});
        l2 = ListNode.generateLinkedList(new int[]{0});
        System.out.println("1: l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers(l1, l2));

        System.out.println();

        l1 = ListNode.generateLinkedList(new int[]{7, 2, 4, 3});
        l2 = ListNode.generateLinkedList(new int[]{5, 6, 4});
        System.out.println("2: l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers2(l1, l2));

        l1 = ListNode.generateLinkedList(new int[]{2, 4, 3});
        l2 = ListNode.generateLinkedList(new int[]{5, 6, 4});
        System.out.println("2: l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers2(l1, l2));

        l1 = ListNode.generateLinkedList(new int[]{0});
        l2 = ListNode.generateLinkedList(new int[]{0});
        System.out.println("2: l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers2(l1, l2));
    }
}
