package offer;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class reConstructBinaryTree {
    /*
    递归思想，前序遍历的第一个元素肯定是根节点，对应的找到中序遍历中这个根节点的位置；
    以根节点为界，劈成左右两半，左半边是它的左子树，右半边是它的右子树；
    那么，左半数组的长度，就是左子树节点的个数，叫p好了；
    由此可知，前序数组中，从根节点往后p个节点都是左子树的节点，因为前序遍历必定先访问完左子树；
    这样以来，前序数组和中序数组都被分成了两半，用来构造这个根节点的左子树和右子树；
    递归执行即可；
     */
    public TreeNode reConstructBinaryTree (int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }
    public TreeNode reConstructBinaryTree(
            int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == root.val) {
                root.left = reConstructBinaryTree(
                        pre, startPre+1, startPre+i-startIn, in, startIn, i-1
                );
                root.right = reConstructBinaryTree(
                        pre, startPre+i-startIn+1, endPre, in, i+1, endIn
                );
            }
        }
        return root;
    }
    public void postTraverse(TreeNode root) {
        if (root == null) return;
        postTraverse(root.right);
        postTraverse(root.left);
        System.out.print(root.val+" ");
    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree rt = new reConstructBinaryTree();
        TreeNode root = rt.reConstructBinaryTree(pre, in);
        rt.postTraverse(root);
    }
}
