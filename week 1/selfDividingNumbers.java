class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            int breakdownNum = i; 
            boolean selfDiv = true; 
            while(breakdownNum > 0) {
                int digit = breakdownNum % 10; 
                if(digit != 0 && i % digit == 0) {
                    breakdownNum /=10; 
                }
                else {
                    selfDiv = false;
                    break;
                }
            }  
            if(selfDiv) {
                ret.add(i);
            }
        }
        return ret; 
    }
}