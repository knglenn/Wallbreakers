class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(arr.length!= pattern.length()) {
            return false; 
        }
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            char patternChar = pattern.charAt(i);
            if(!map1.containsKey(arr[i])) {
                map1.put(arr[i], patternChar);
            }
            if(!map2.containsKey(patternChar)) {
                map2.put(patternChar, arr[i]);
            }
            if(map1.get(arr[i])!=patternChar || !map2.get(patternChar).equals(arr[i])) {
                return false;
            }
        }
        return true; 
    }
}