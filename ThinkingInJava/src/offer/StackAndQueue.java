package offer;

import java.util.Stack;

public class StackAndQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int n = 0;
    public void push(int node) {
        stack1.push(node);
        n++;
    }

    public int pop() {
        for (int i = 0; i < n; i++) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        int ans = stack2.peek();
        stack2.pop();
        for (int i = 0; i < n - 1; i++) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
        n--;
        return ans;
    }
    public static void main(String[] args) {
        StackAndQueue stackAndQueue = new StackAndQueue();
        stackAndQueue.push(1);
        stackAndQueue.push(2);
        stackAndQueue.push(3);
        System.out.println(stackAndQueue.stack1+" "+stackAndQueue.stack2);
        System.out.println(stackAndQueue.pop());
        System.out.println(stackAndQueue.stack1+" "+stackAndQueue.stack2);
        System.out.println(stackAndQueue.pop());
        System.out.println(stackAndQueue.stack1+" "+stackAndQueue.stack2);
        System.out.println(stackAndQueue.pop());
    }
}