package offer;
import java.util.*;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode t = null;
        while (!queue.isEmpty()) {
            t = queue.peek();
            queue.pop();
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
            ans.add(t.val);
        }
        return ans;
    }
}
