class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length()!=t.length()) {
            return false; 
        }
        int[] letterTable = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            letterTable[s.charAt(i) - 'a']++;
            letterTable[t.charAt(i) - 'a']--;
        }
        
        for(int i : letterTable) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}