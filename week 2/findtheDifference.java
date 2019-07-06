class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        
        for(int i = 0; i < t.length(); i++) {
            if(i < s.length()) {
                sum-=  s.charAt(i);
            }
            sum+= t.charAt(i);
        }
        return (char) sum; 
    }
}