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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> toTraverse = new LinkedList<>();
        toTraverse.add(root);

        while (!toTraverse.isEmpty()) {
            List<Integer> values = new ArrayList<>();

            for (int i = toTraverse.size(); i > 0; i--) {
                
                var node = toTraverse.poll();
                values.add(node.val);
                if (node.left != null) toTraverse.add(node.left);
                if (node.right != null) toTraverse.add(node.right);
            
            }            
            
            result.add(values);
        }
        
        return result;
    }
}
