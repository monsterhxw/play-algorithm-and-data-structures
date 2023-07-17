/**
 * @author huangxuewei
 * @since 2023/7/17
 */
public class Solution20230717 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;

            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            pre = node1;
        }

        return dummyHead.next;
    }

    public ListNode swapPairsR(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsR(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Solution20230717 solution = new Solution20230717();

        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        head = ListNode.generateLinkedList(new int[]{});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        head = ListNode.generateLinkedList(new int[]{1});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        System.out.println();

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));

        head = ListNode.generateLinkedList(new int[]{});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));

        head = ListNode.generateLinkedList(new int[]{1});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));
    }
}
