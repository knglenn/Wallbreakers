/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        helper(ret, root);
        
        return ret; 
    }
    
    public void helper(List<Integer> list, Node root) {
        if(root == null) {
            return;
        }
        for(Node child : root.children) {
            helper(list, child);
        }
        list.add(root.val);
    }
    
}