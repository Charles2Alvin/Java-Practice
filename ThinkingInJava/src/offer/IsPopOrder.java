package offer;
import symbols.Array;

import java.util.*;
public class IsPopOrder {
    /**
     * 思路就是用一个栈来模拟这个过程；
     * 遍历popA数组，看看它想弹出什么；
     * 如果栈里面没有它想弹的，就把pushA的元素入栈，直到pushA的栈顶为弹出的元素；
     * 如果有的话，就弹出popA的元素（指针右移等价于弹出），
     * 如果popA的下一个元素与栈的栈顶相同，那就继续弹，直到没有为止；
     * 如果pushA里的元素都用完了，栈非空，说明不是可能的pop序列
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push((pushA[i]));
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        HashSet s1 = new HashSet(), s2 = new HashSet();
        for (int i = 0; i < pushA.length; i++) {
            s1.add(pushA[i]);
            s2.add(popA[i]);
        }
        if (!s1.equals(s2)) return false;

        int n = pushA.length;
        LinkedList lst = new LinkedList<>();
        for (int i = 0; i < pushA.length; i++) {
            lst.add(pushA[n - i - 1]);
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        int count = 0;
        for (int i = 0; i < popA.length; i++) {
            for (int j = i; j < popA.length; j++) {
                int indexI = lst.indexOf(popA[i]);
                int indexJ = lst.indexOf(popA[j]);
                System.out.println(i+" "+j+" "+indexI+" "+indexJ);
                if (indexI > indexJ) count++;
                if (count >= 2) return false;
            }
        }
        System.out.println(count);
        return true;
    }
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {3,5,4,2,9};
        System.out.println(new IsPopOrder().IsPopOrder(pushA, popA));
    }
}
