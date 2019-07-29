/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxDepth = 0;
    int maxLeaf = 0;
    public int findBottomLeftValue(TreeNode root) {
        getDepth(root, 1);
        return maxLeaf;
    }
    public void getDepth(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
       if (depth > maxDepth) {
           maxDepth = depth;
           maxLeaf = root.val;
       }
        getDepth(root.left, depth + 1);
        getDepth(root.right, depth + 1);
    }
}