class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ret = new ArrayList();
        if(s == null || s.isEmpty() || p.length() > s.length()) {
            return ret; 
        }
        List<Character> key = new ArrayList();
        for(char c : p.toCharArray()) {
            key.add(c);
        }
        Collections.sort(key);
        
        List<Character> window = new ArrayList();
        
        for(int i = 0; i < p.length(); i++) {
            window.add(s.charAt(i));
        }
        
        Collections.sort(window);
        if(window.equals(key)) {
            ret.add(0);
        }
        int lastIndex = Collections.binarySearch(window, s.charAt(0));
        for(int i = 1; i < s.length() - p.length() + 1; i++) {
            window.remove(lastIndex);
            int insertionPoint = Collections.binarySearch(window, s.charAt(i + p.length() -1));
            //if not found, returns -(insertionpoint) -1
            if(insertionPoint < 0) {
                insertionPoint = -insertionPoint -1; 
            }
            window.add(insertionPoint, s.charAt(i + p.length() -1));
            if(window.equals(key)) {
                ret.add(i);
            }
            lastIndex = Collections.binarySearch(window, s.charAt(i));
        }
        
        return ret; 
    }
}