package leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}

/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2, p = new ListNode(0), ret = p;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = new ListNode(h1.val);
                h1 = h1.next;
                p = p.next;
                continue;
            }
            else {
                p.next = new ListNode(h2.val);
                h2 = h2.next;
                p = p.next;
                continue;
            }
        }
        //h1为空，则补上h2的剩余元素
        if (h1 == null) {
            while (h2 != null) {
                p.next = new ListNode(h2.val);
                p = p.next;
                h2 = h2.next;
            }
        }
        //h1为空，则补上h2的剩余元素
        if (h2 == null) {
            while (h1 != null) {
                p.next = new ListNode(h1.val);
                p = p.next;
                h1 = h1.next;
            }
        }
        return ret.next;
    }
}
 */