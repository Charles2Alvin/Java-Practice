package leetcode;

public class hasCycle {
    /*
    使用Floyd跑圈算法；
    两个快慢指针；如果存在圈，那么跑的过程中快指针会追上慢指针，这时候它多跑了k圈；
    如果遍历过程出现相等，则存在环路；
    否则，快指针会到达链表尾部，跳出循环，这时候返回false；
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
