package leetcode;


public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        ListNode p = this;
        while (p != null) {
            s.append(p.val + " ");
            p = p.next;
        }
        return s.toString();
    }
}
