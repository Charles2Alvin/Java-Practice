package offer;

import java.util.Random;

public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        //复制原链表，在每个节点后面插入它的copy
        while (cur != null) {
            RandomListNode cp = new RandomListNode(cur.label);
            cp.next = cur.next;
            cur.next = cp;
            cur = cp.next;
        }
        cur = pHead;
        //为copy的节点复制random引用
        while (cur != null) {
            RandomListNode nxt = cur.next;
            if (cur.random != null) {
                nxt.random = cur.random.next;
            }
            cur = nxt.next;
        }
        //拆分原来的链表，每一个节点的next都置为next的next，拆成原来的样子
        RandomListNode cloneHead = pHead.next;
        cur = pHead;
        while (cur.next != null) {
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return cloneHead;
    }
}
