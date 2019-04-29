package offer;

import leetcode.ListNode;
import java.util.*;

public class PrintList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> lst = new ArrayList<>();
        ListNode p = listNode; int n = 0;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
            n++;
        }
        for (int i = 0; i < n; i++) {
            lst.add(stack.peek());
            stack.pop();
        }
        return lst;

    }
}