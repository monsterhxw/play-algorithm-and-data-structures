/**
 * @author huangxuewei
 * @since 2023/7/17
 */
public class Solution20230717 {

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
