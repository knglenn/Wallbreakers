class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>();
        while(true) {
            int sum = 0; 
            while(n > 0) {
                int digit = n % 10; 
                sum += (digit * digit);
                n/=10; 
             }
            if(sum == 1) {
                break;
            }
            if(!nums.add(sum)) {
                return false; 
            }
            n = sum;
        }
        return true; 
    }
 
}