package leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class isPalindrome {
    /*
    用可变参数列表
     */
    public static ListNode makeList(int... nums) {
        ListNode head = new ListNode(0), p = head;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return head.next;
    }

    /*
    快慢指针法，两个指针同时遍历链表，用栈存储，快指针到达链表尾部时，栈里刚好存了一半的元素；
    如果链表长度为奇数，则弹出栈顶（中位数）；若偶数，pass；
    接着慢指针继续遍历，并与栈顶比较，不同时返回false，循环结束返回true；
    时间复杂度是O(n);
     */
    public static boolean isPalindrome(ListNode head) {
        LinkedList<Integer> s = new LinkedList<>();
        ListNode p = head, q = head;
        while (q != null) {
            s.addFirst(p.val);
            p = p.next;
            if (q.next != null)
                q = q.next.next;
            else {
                s.removeFirst();
                q = q.next;
            }
        }
        System.out.println(s);
        while (!s.isEmpty()) {
            System.out.println("Comparing: "+s.getFirst()+" "+p.val);
            if (s.getFirst() != p.val) {
                return false;
            }
            s.removeFirst();
            p = p.next;
        }
        return true;
    }

    /*
    主要思想是反向遍历。先顺序遍历，将链表元素存入栈中；再重头遍历，比较链表和栈顶元素
    时间复杂度是O(2*n);
     */
    public static boolean isPalindrome2(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while (p != null) {
            s.push(p.val);
            p = p.next;
        }
        System.out.println(s);
        while (!s.empty()) {
            System.out.println("Comparing: "+s.peek()+" "+head.val);
            if (s.peek() != head.val) {
                return false;
            }
            s.pop();
            head = head.next;
        }
        return true;
    }

    /*
    快慢指针，先让快指针找到与表头相同的节点，如果它后面还有东西，就返回false，否则继续；
    砍掉已经比较过的元素（快指针所在的节点），然后重复以上过程；
     */
    public static boolean isPalindrome3(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        if(head.next.next==null){
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next!=null){
            if(slow.val == fast.next.val){
                if(fast.next.next!=null){
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if(fast == null || slow.val == fast.val){
                    return true;
                }
            }else{
                fast = fast.next;
            }
        }
        return false;
    }

    /*
    快慢指针，先找到链表中点，反转后半段链表，然后两个半段从头开始比较
     */
    public static boolean isPalindrome4(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverseList(slow.next);

        while (head != null && reverseHead != null) {
            if (head.val != reverseHead.val)
                return false;
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = null;
        ListNode q;
        while (head != null) {
            q = head.next;
            head.next = p;

            p = head;
            head = q;
        }
        return p;
    }
    public static void main(String[] args) {
        ListNode head = makeList(1,2,3,4,3,2,1);
        //System.out.println(head);
        System.out.println(isPalindrome3(head));
    }
}
