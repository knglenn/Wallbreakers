class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ret = new ArrayList();
        if(s == null | s.isEmpty() || p.length() > s.length()) {
            return ret; 
        }
        int[] chars = new int[26];
        
        for(int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a']++;
        }
        
        int remainingCharacters = p.length();
        int start = 0; 
        int end = 0; 
        
        while(end < p.length()) {
            int index = s.charAt(end) - 'a';
            chars[index]--;
            if(chars[index] >= 0) {
                remainingCharacters--;
            }
            end++;
        }
        if(remainingCharacters == 0) {
            ret.add(start);
        }
        
        while(end < s.length()) {
            int index = s.charAt(start) - 'a';
            
            if(chars[index] >= 0) {
                remainingCharacters++;
            }
            chars[index]++;
            start++;
            
            index = s.charAt(end) - 'a';
            chars[index]--;
            if(chars[index] >= 0) {
                remainingCharacters--;
            }
            end++;
            
            if(remainingCharacters == 0) {
                ret.add(start);
            }
        }
        
        return ret; 
    }
}