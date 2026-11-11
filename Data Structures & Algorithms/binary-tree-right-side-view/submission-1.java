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
    public List<Integer> rightSideView(TreeNode root) {
        // null edge case
        List<Integer> visible = new ArrayList<>();
        if (root == null) return visible;
        
        // need to explore, seed root
        Queue<TreeNode> toExplore = new LinkedList<>();
        toExplore.add(root);
        
        while (!toExplore.isEmpty()) {
            // find the current level
            // in desc order i.e.
            // right (larger) child first
            List<Integer> level = new ArrayList<>();
            
            // size gives the number of nodes in current level
            int levelSize = toExplore.size();
            for (int i = 0; i < levelSize; i++) {
                
                var node = toExplore.poll();

                if (i == 0)
                    visible.add(node.val);
                
                if (node.right != null) toExplore.add(node.right);
                if (node.left != null) toExplore.add(node.left);
                
            }
            
        }
        
        return visible;
    }
}
