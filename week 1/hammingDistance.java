class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        
        int ones = 0;
        while(xor > 0) {
            ones+= (xor & 1);
            xor = xor >> 1; 
        }
        return ones; 
    }
}