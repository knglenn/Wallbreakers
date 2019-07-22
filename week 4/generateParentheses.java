class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>(); 
        backtrack(ret, new StringBuilder(), n, 0, 0);
        return ret; 
    }
    public void backtrack(List<String> ret, StringBuilder sb, int n, int closePar, int openPar) {
        if(sb.length() == n * 2) {
            ret.add(sb.toString());
        }
        else {
            if(openPar < n) {
                backtrack(ret, sb.append('('), n, closePar, openPar + 1);
                sb.delete(sb.length() -1, sb.length());
            }
            if(closePar < openPar) {
                backtrack(ret, sb.append(')'), n, closePar + 1, openPar);
                sb.delete(sb.length() -1, sb.length());
            }
        }
    }
}