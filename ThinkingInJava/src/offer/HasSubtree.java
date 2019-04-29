package offer;
/**
 *  先在树A中找到与树B值相同的点，然后判断以这个点为根节点的树是否与B的结构是否相同；
 *  相同的话即可返回true， 不同就继续找
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val)
            result = sameTree(root1, root2);
        if (!result) result = sameTree(root1.left, root2);
        if (!result) result = sameTree(root1.right, root2);
        return result;
    }
    public boolean sameTree(TreeNode root1, TreeNode root2) {
        //B是空树或者A中对应结构比它多下面的部分，也算是被包含在那个子结构里
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return sameTree(root1.left, root2.left)
                && sameTree(root1.right, root2.right);
    }
}
