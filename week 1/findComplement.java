class Solution {
    public int findComplement(int num) {
        int onesVal = 0; 
       int i = 0; 
        while (onesVal < num) {
           onesVal+= (1 << i);
            i++;
        }
        return onesVal - num; 
    }
}