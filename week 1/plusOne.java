class Solution {
    public int[] plusOne(int[] digits) {
       
        int n = digits.length;
        if(digits[n -1] + 1 < 10) {
            digits[n -1]++; 
            return digits; 
        }
        
        if(digits[0] == 9){
            int[] newArr = new int[n + 1];
            newArr[0] = 1; 
            return newArr;
        }
        
        int i = n - 1;
        while(digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        digits[i]++;
        return digits; 
    }
}