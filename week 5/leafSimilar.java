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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        helper(list1, root1);
        helper(list2, root2);
        return list1.equals(list2);
    }
    
    public void helper(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        helper(list, root.left);
        helper(list, root.right);
    }
    
}