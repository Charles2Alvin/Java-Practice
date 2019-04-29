package offer;
/**
 public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
 }
 */
/*
这个思路就很简单啦；
二叉树的题目，一般都要递归求解；
那递归一下不就出来了嘛hhhhh；
 */
public class reverseBinaryTree {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}