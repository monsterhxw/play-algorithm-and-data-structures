/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;

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
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

        ListNode l1;
        ListNode l2;

        l1 = ListNode.generateLinkedList(new int[]{2, 4, 3});
        l2 = ListNode.generateLinkedList(new int[]{5, 6, 4});
        System.out.println("l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers(l1, l2));

        l1 = ListNode.generateLinkedList(new int[]{0});
        l2 = ListNode.generateLinkedList(new int[]{0});
        System.out.println("l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers(l1, l2));

        l1 = ListNode.generateLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = ListNode.generateLinkedList(new int[]{9, 9, 9, 9});
        System.out.println("l1: " + l1 + ", l2: " + l2 + ", result: " + solution.addTwoNumbers(l1, l2));
    }
}
