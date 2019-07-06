class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? false : true);
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))) {
                return i;
            }
        }
        return -1; 
    }
}