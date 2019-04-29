package offer;
/**
 * 平衡二叉树是指左右子树深度相差不大于1的树；
 * 简单的办法是求左右子树的高度，判断是否平衡；
 * 但是这样会重复遍历相同的节点；
 * 剪枝法：
 * 后序遍历二叉树，在不平衡处返回-1；
 * 先遍历左子树求最大深度，若返回为-1则也返回-1，再遍历右子树也同理；
 * 遍历完左右子树深度后，判断是否平衡，平衡则返回最大深度，否则返回-1；
 */
public class isBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return maxDepth(root) != -1;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        if (left == -1) return -1;
        int right = maxDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ?
                -1 : 1 + Math.max(left, right);
    }
}