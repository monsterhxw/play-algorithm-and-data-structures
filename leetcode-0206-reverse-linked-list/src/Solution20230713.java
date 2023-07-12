/**
 * @author huangxuewei
 * @since 2023/7/13
 */
public class Solution20230713 {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode generateLinkedList(int[] nums) {
            ListNode dummyHead = new ListNode(-1);
            ListNode prev = dummyHead;
            for (int i = 0; i < nums.length; i++) {
                prev.next = new ListNode(nums[i]);
                prev = prev.next;
            }
            return dummyHead.next;
        }

        public static String toStr(ListNode node) {
            StringBuilder sb = new StringBuilder();
            ListNode cur = node;
            while (cur != null) {
                sb.append(cur.val);
                sb.append("->");
                cur = cur.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static void main(String[] args) {
        Solution20230713 solution = new Solution20230713();
        int[] nums;
        ListNode head;

        nums = new int[]{1, 2, 3, 4, 5};
        head = ListNode.generateLinkedList(nums);
        System.out.print("1: head: " + ListNode.toStr(head));
        head = solution.reverseList(head);
        System.out.println(", result: " + ListNode.toStr(head));

        nums = new int[]{1, 2};
        head = ListNode.generateLinkedList(nums);
        System.out.print("1: head: " + ListNode.toStr(head));
        head = solution.reverseList(head);
        System.out.println(", result: " + ListNode.toStr(head));

        nums = new int[]{};
        head = ListNode.generateLinkedList(nums);
        System.out.print("1: head: " + ListNode.toStr(head));
        head = solution.reverseList(head);
        System.out.println(", result: " + ListNode.toStr(head));

        nums = new int[]{1, 2, 3, 4, 5};
        head = ListNode.generateLinkedList(nums);
        System.out.print("2: head: " + ListNode.toStr(head));
        head = solution.reverseList2(head);
        System.out.println(", result: " + ListNode.toStr(head));

        nums = new int[]{1, 2};
        head = ListNode.generateLinkedList(nums);
        System.out.print("2: head: " + ListNode.toStr(head));
        head = solution.reverseList2(head);
        System.out.println(", result: " + ListNode.toStr(head));

        nums = new int[]{};
        head = ListNode.generateLinkedList(nums);
        System.out.print("2: head: " + ListNode.toStr(head));
        head = solution.reverseList2(head);
        System.out.println(", result: " + ListNode.toStr(head));
    }
}
