class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Boolean> map= new HashMap<>();
        
        String combined = A + " " + B;
        
        String[] words = combined.split(" ");
        
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.containsKey(words[i]) ? false : true);
        }
        
        HashSet<String> unique = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            if(map.get(words[i])) {
                unique.add(words[i]);
            }
        }
        
        return unique.toArray(new String[unique.size()]);
        
    }
}