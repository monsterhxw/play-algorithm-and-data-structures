package leetcode;

/**
 * @author huangxuewei
 * @since 2023/6/22
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        ListNode prev = head;
        while (prev != null && prev.next != null) {
            if (val == prev.next.val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, null);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        static ListNode generate(int[] arr) {
            ListNode head = new ListNode(arr[0]);
            ListNode prev = head;
            for (int i = 1; i < arr.length; i++) {
                prev.next = new ListNode(arr[i]);
                prev = prev.next;
            }
            return head;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val).append("->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        System.out.println(sum(arr));
        ListNode head = ListNode.generate(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode listNode = (new Solution203()).removeElements3(head, 6);
        System.out.println(listNode);
    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
