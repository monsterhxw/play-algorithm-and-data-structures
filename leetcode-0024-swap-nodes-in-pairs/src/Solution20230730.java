/**
 * @author huangxuewei
 * @since 2023/7/30
 */
public class Solution20230730 {

    public ListNode swapPairsR(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsR(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummHead = new ListNode(-1);
        dummHead.next = head;
        ListNode prev = dummHead;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }
        return dummHead.next;
    }

    public static void main(String[] args) {
        Solution20230730 solution = new Solution20230730();

        ListNode head;

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        head = ListNode.generateLinkedList(new int[]{});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        head = ListNode.generateLinkedList(new int[]{1});
        System.out.println("1: head: " + head + ", result: " + solution.swapPairs(head));

        System.out.println();

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));

        head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));

        head = ListNode.generateLinkedList(new int[]{});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));

        head = ListNode.generateLinkedList(new int[]{1});
        System.out.println("2: head: " + head + ", result: " + solution.swapPairsR(head));
    }
}
