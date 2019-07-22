class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        //initial score 
        stack.push(0);
        for(char c : S.toCharArray()) {
            if(c == '(') {
                //started new depth
                stack.push(0);
            }
            else {
                int prevScore = stack.pop();
                int depthScore = stack.pop();
                //if prevScore is not equal to 0, this means you are embedded within a group of parentheses. Otherwise, you have a ()
                stack.push(depthScore + Math.max(2 * prevScore, 1));
            }
        }
        return stack.pop();
    }
}