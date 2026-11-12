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
    public int goodNodes(TreeNode root) {
        int[] nodes = {0};

        dfs(root, Integer.MIN_VALUE, nodes);

        return nodes[0];

    }

    private void dfs(TreeNode root, int max, int[] nodes) {
        if (root.val >= max) {
            nodes[0]++;
            max = root.val;
        }

        if (root.left != null) dfs(root.left, max, nodes);
        if (root.right != null) dfs(root.right, max, nodes);

    }
}
