public class ListNode {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
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
}