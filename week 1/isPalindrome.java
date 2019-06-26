class Solution {
    public boolean isPalindrome(String s) {
        
        String lower = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for(int i = 0; i < lower.length()/2; i++) {
           if(lower.charAt(i) != lower.charAt(lower.length() - 1 - i)) {
               return false; 
           }
            
        }
        return true; 
    }
}