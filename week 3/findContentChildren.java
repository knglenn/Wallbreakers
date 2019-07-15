class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g== null || s == null || g.length == 0 || s.length == 0) {
            return 0; 
        }
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex = 0; 
        for(int i = 0; i < s.length && childIndex < g.length; i++) {
            int greed = g[childIndex];
            int size = s[i];
            
            if(size >= greed) {
                childIndex++;
            }
            
        }
        return childIndex;
    }
}