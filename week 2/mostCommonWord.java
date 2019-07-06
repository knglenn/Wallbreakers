class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedList = new HashSet<>();
        for(String s : banned) {
            bannedList.add(s);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        //this ridiculous statement was required because of the last test case using apostrophes to form a word, despite the problem notes saying that words cannot consist of punctuation symbols 
        paragraph = paragraph.replaceAll(",", " ").replaceAll("  ", " ").replaceAll("\\p{P}", "");
        String[] words = paragraph.toLowerCase().split(" ");
        String maxS = null; 
        int max = Integer.MIN_VALUE; 
        
        for(String s : words) {
            if(!bannedList.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if(map.get(s) > max) {
                    maxS = s;
                    max = map.get(s);
                }
            }
        }
        
        return maxS; 
    }
}