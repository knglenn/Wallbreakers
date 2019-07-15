class Solution {
    public int[] plusOne(int[] digits) {
       
        int n = digits.length;
        if(digits[n -1] + 1 < 10) {
            digits[n -1]++; 
            return digits; 
        }
        int i = n - 1;
        while(i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        if(digits[0] == 0) {
            int[] newArr = new int[n + 1];
            newArr[0] = 1; 
            return newArr; 
        }
        digits[i]++;
        return digits; 
    }
}