class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> transforms = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            String temp = words[i];
            for(int j = 0; j < temp.length(); j++) {
                sb.append(morse[temp.charAt(j) - 'a']);
            }
            transforms.add(sb.toString());
        }
        
        return transforms.size();
    }
}