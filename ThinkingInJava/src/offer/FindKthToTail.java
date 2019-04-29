package offer;
import leetcode.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode p = head, q = p.next;
        for (int i = 0; i < k - 1; i++) {
            if (q == null) return null;
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}