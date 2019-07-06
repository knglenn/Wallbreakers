class Solution {
    public String longestWord(String[] words) {
        HashSet<String> dictionary = new HashSet<>();
        for(String s : words) {
            dictionary.add(s);
        }
        
        String maxWord = "";
        for(String s : words) {
            boolean isSub = true; 
            for(int i = 1; i < s.length(); i++) {
                if(!dictionary.contains(s.substring(0, i))) {
                    isSub = false;
                    break;
                }
            }
            if(isSub) {
                if(s.length() > maxWord.length()) {
                    maxWord = s;
                }
                else if (s.length() == maxWord.length()) {
                    maxWord = maxWord.compareTo(s) < 1 ? maxWord : s; 
                }
            }
        }
        return maxWord; 
    }
}