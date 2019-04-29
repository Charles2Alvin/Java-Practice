package offer;
import symbols.Array;

import java.util.*;
public class FindPath {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return ans;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            ans.add(new ArrayList<>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        return ans;
    }

}
