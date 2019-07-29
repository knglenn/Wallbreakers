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
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return height; 
    }
    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0; 
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        height = Math.max(height, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1; 
    }
}