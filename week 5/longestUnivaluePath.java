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
    int height = 0; 
    int currentVal = 0; 
    public int longestUnivaluePath(TreeNode root) {
        getHeight(root, 0);
        return height;
    }
    public int getHeight(TreeNode root, int currentVal) {
        if(root == null) {
            return 0; 
        }
        int leftHeight = getHeight(root.left, root.val);
        int rightHeight = getHeight(root.right, root.val);
        height = Math.max(height, leftHeight + rightHeight);
        
        return root.val == currentVal ? Math.max(leftHeight, rightHeight) + 1 : 0;
    }
}