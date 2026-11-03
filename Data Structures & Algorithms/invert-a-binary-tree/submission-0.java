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
    public TreeNode invertTree(TreeNode root) {
        // early exit
        if (root == null) return root;

        // swap left and right
        // call recursive for left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        
        return root;
    }
}
