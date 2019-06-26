class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String master = strs[0];
        for(int i = 0; i < master.length(); i++) {
            char match = master.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length()|| strs[j].charAt(i) != match) {
                    return master.substring(0, i);
                }
            }
        }
        return master;
    }
}