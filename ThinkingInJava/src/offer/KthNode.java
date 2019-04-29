package offer;
import java.util.*;
public class KthNode {
    ArrayList<TreeNode> lst = new ArrayList<>();
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k == 0) return null;
        inorder(root);
        int len = lst.size();
        if (k > len) return null;
        return lst.get(k-1);

    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        lst.add(root);
        inorder(root.right);
    }
}
