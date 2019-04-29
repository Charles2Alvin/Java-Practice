package leetcode;
import java.util.*;
//*
// * Definition for singly-linked list.


public class reverseList { }
class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> stack = new ArrayList<>();
        ListNode l = head;
        while(l != null) {
            stack.add(l.val);
            l = l.next;
        }
        ListNode ret = new ListNode(1);
        ListNode n = ret;
        for (int i = stack.size()-1; i >= 0; i--) {
            System.out.println(stack.get(i));
            ret.next = new ListNode(stack.get(i));
            ret = ret.next;
        }
        return n.next;
    }
}
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}

class Solution2 {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;   // 下一个节点

        while (cur != null) {
            // 拿到原来链表head的下一个节点
            next = cur.next;
            // 把当前链表的下一个节点指向上一个节点也就是pre
            cur.next = pre;
            // 重置pre为当前链表节点
            pre = cur;
            // 重置当前节点
            cur = next;
        }
        // 返回反转后的链表 也就是pre 其实就是cur
        return pre;
    }
}