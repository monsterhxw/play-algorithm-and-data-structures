/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode precursor = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            precursor = precursor.next;
        }

        ListNode successor = precursor;
        for (int i = left; i <= right + 1; i++) {
            successor = successor.next;
        }

        ListNode reverse = reverseList(precursor.next, successor);
        precursor.next = reverse;

        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head, ListNode successor) {
        ListNode pre = successor;
        ListNode cur = head;
        while (cur != successor) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();

        int[] nums;
        int left, right;
        ListNode head;

        nums = new int[]{1, 2, 3, 4, 5};
        left = 2;
        right = 4;
        head = ListNode.generateLinkedList(nums);
        System.out.print("head: " + head);
        head = solution.reverseBetween(head, left, right);
        System.out.println(", result: " + head);

        nums = new int[]{5};
        left = 1;
        right = 1;
        head = ListNode.generateLinkedList(nums);
        System.out.print("head: " + head);
        head = solution.reverseBetween(head, left, right);
        System.out.println(", result: " + head);

        nums = new int[]{3, 5};
        left = 1;
        right = 2;
        head = ListNode.generateLinkedList(nums);
        System.out.print("head: " + head);
        head = solution.reverseBetween(head, left, right);
        System.out.println(", result: " + head);

        System.out.println();

        nums = new int[]{1, 2, 3, 4, 5};
        left = 2;
        right = 4;
        head = ListNode.generateLinkedList(nums);
        System.out.print("2: head: " + head);
        head = solution.reverseBetween2(head, left, right);
        System.out.println(", result: " + head);

        nums = new int[]{5};
        left = 1;
        right = 1;
        head = ListNode.generateLinkedList(nums);
        System.out.print("2: head: " + head);
        head = solution.reverseBetween2(head, left, right);
        System.out.println(", result: " + head);

        nums = new int[]{3, 5};
        left = 1;
        right = 2;
        head = ListNode.generateLinkedList(nums);
        System.out.print("2: head: " + head);
        head = solution.reverseBetween2(head, left, right);
        System.out.println(", result: " + head);
    }
}
