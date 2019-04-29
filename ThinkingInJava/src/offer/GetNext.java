package offer;
/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
import java.util.*;
public class GetNext {
    /***
     * 分两种情况讨论：当前节点有右孩子和没有右孩子；
     * 假如有右孩子，在中序遍历中的下一节点必是右孩子的最左节点；
     * 假如没有右孩子，说明发生了回溯，要到父节点以上的地方去找；
     * 那么通过父亲指针回溯到哪里才停呢？
     * 假如当前节点是父亲的右孩子，那这个父亲一定是中序时遍历过的了，现在回溯时经过了它；
     * 如果当前节点是父亲的左孩子，那这个父亲正是要求的节点；
     * @param root
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode root) {
        if (root == null) return null;
        if (root.right != null) {
            root = root.right;
            while (root.left != null)
                root = root.left;
            return root;
        }
        while (root.next != null) {
            if (root == root.next.left) return root.next;
            root = root.next;
        }
        return null;
    }

    /**
     * 与上几乎相同，只是情况三可以考虑成寻找一个节点，使它的左孩子的最右节点是pNode即可；
     * @param root
     * @return
     */
    public TreeLinkNode GetNext2(TreeLinkNode root) {
        if (root.right != null) return leftMost(root.right);
        else {
            TreeLinkNode p = root.next;
            while (p != null && root != rightMost(p.left))
                p = p.next;
            return p;
        }
    }
    public static TreeLinkNode leftMost(TreeLinkNode root) {
        if (root == null) return null;
        if (root.left != null) return leftMost(root.left);
        else return root;
    }
    public static TreeLinkNode rightMost(TreeLinkNode root) {
        if (root == null) return null;
        if (root.right != null) return rightMost(root.right);
        else return root;
    }

}
