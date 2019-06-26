class Solution {
    public String reverseVowels(String s) {
        char[] cArr = s.toCharArray();
        int j = s.length() -1;
        for(int i = 0; i < j; i++) {
            if(vowel(cArr[i])) {
                while(j > i && !vowel(cArr[j])) {
                    j--;
                }
                if(j > i && vowel(cArr[j])) {
                    char temp = cArr[i];
                    cArr[i] = cArr[j];
                    cArr[j] = temp; 
                    j--;
                }
            }
        }
        return new String(cArr);
    }
    
    public boolean vowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}