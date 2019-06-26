class Solution {
    public int binaryGap(int N) {
        int distance = 0; 
        int max = 0; 
        boolean start = false; 
        int prev = 0;
        while(N > 0) {
            int current = N & 1; 
            if(!start && current == 1) {
                start = true; 
            }
            else if(start) {
                distance++;
                if(current == 1) {   
                    max = Math.max(distance, max);
                    distance = 0; 
                }
            }
            
            N = N >> 1; 
        }
        return max; 
    }
}