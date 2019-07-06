class Solution {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> specials = new HashSet<>();
        
        for(String s : A) {
            int[] evens = new int[26];
            int[] odds = new int[26];
            for(int i = 0; i < s.length(); i++) {
                if(i % 2 == 0) {
                    evens[s.charAt(i) - 'a']++;
                }
                else {
                    odds[s.charAt(i) - 'a']++;
                }
            }
            specials.add(Arrays.toString(evens) + Arrays.toString(odds));
        }
        return specials.size();
    }
}