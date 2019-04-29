package leetcode;

import java.util.*;

public class simplifyPath {
    /*
    用栈解决问题；
    这题关键在于理解它要表达的简化规则，碰到"."是当前目录，可以不用管，碰到""也不用管，
    碰到".."就要弹出栈顶；
    做法：第一步要去掉它所有的"/"，用String的split方法；
    碰到非特殊字符串时，入栈；碰到".."时若栈非空，出栈
    最后从栈底开始遍历栈，加入"/"，显然使用双端队列更爽；
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            System.out.println("Scanning: " + dir);
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            else if (!dir.equals("") && !dir.equals(".") && !dir.equals("..")) {
                stack.push(dir);
            }
        }
        ArrayList<String> list = new ArrayList<>(stack);
        //注意join方法，在每个元素之间插入"/"
        return "/" + String.join("/",list);
    }
    public static void main(String[] args) {
        String path = "/home//foo/";
        simplifyPath s = new simplifyPath();
        System.out.println(s.simplifyPath(path));
    }
}
