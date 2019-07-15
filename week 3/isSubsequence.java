class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if(index == -1) {
                return false; 
            }
        }
        return true; 
    }
}