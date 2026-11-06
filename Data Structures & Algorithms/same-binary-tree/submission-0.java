/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] isSame = {true};
        dfs(p, q, isSame);
        return isSame[0];
    }

    private void dfs(TreeNode p, TreeNode q, boolean[] isSame) {
        if (p == null && q == null) return;
        else if (
            (p == null && q != null) ||
            (q == null && p != null) ||
            (p.val != q.val)   
        ) {
            isSame[0] = false;
            return;
        };

        dfs(p.left, q.left, isSame);
        dfs(p.right, q.right, isSame);
    };
}
