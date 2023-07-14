/**
 * @author huangxuewei
 * @since 2023/7/15
 */
public class Solution20230715 {

    public ListNode mergeTwoListsR(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val <= list2.val) {
                list1.next = mergeTwoListsR(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoListsR(list1, list2.next);
                return list2;
            }
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                pre.next = list2;
                break;
            } else if (list2 == null) {
                pre.next = list1;
                break;
            } else {
                if (list1.val <= list2.val) {
                    pre.next = list1;
                    pre = pre.next;
                    list1 = list1.next;
                } else {
                    pre.next = list2;
                    pre = pre.next;
                    list2 = list2.next;
                }
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution20230715 solution = new Solution20230715();

        ListNode list1;
        ListNode list2;

        list1 = ListNode.generateLinkedList(new int[]{1, 2, 4});
        list2 = ListNode.generateLinkedList(new int[]{1, 3, 4});
        System.out.println("1: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoLists(list1, list2));

        list1 = ListNode.generateLinkedList(new int[]{});
        list2 = ListNode.generateLinkedList(new int[]{});
        System.out.println("1: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoLists(list1, list2));

        list1 = ListNode.generateLinkedList(new int[]{});
        list2 = ListNode.generateLinkedList(new int[]{0});
        System.out.println("1: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoLists(list1, list2));

        System.out.println();

        list1 = ListNode.generateLinkedList(new int[]{1, 2, 4});
        list2 = ListNode.generateLinkedList(new int[]{1, 3, 4});
        System.out.println("2: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoListsR(list1, list2));

        list1 = ListNode.generateLinkedList(new int[]{});
        list2 = ListNode.generateLinkedList(new int[]{});
        System.out.println("2: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoListsR(list1, list2));

        list1 = ListNode.generateLinkedList(new int[]{});
        list2 = ListNode.generateLinkedList(new int[]{0});
        System.out.println("2: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoListsR(list1, list2));

        list1 = ListNode.generateLinkedList(new int[]{5});
        list2 = ListNode.generateLinkedList(new int[]{1, 2, 4});
        System.out.println("2: list1: " + list1 + ", list2: " + list2 + ", result: " + solution.mergeTwoListsR(list1, list2));
    }
}
