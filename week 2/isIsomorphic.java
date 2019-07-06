class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false; 
        }
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            
            if(!sMap.containsKey(cS)) {
                sMap.put(cS, cT);
            }
            if(!tMap.containsKey(cT)) {
                tMap.put(cT, cS);
            }
            if(sMap.get(cS) != cT || tMap.get(cT) != cS) {
                return false;
            }
        }
        return true; 
    }
}