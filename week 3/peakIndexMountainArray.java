class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int hi = A.length -1; 
        int lo = 0;
        
        while(hi >= lo) {
            int middle = (hi + lo) /2; 

            if(A[middle] < A[middle + 1]) {
                lo = middle + 1; 
            }
            else if(A[middle -1] > A[middle]) {
                hi = middle -1; 
            }
            else {
                return middle; 
            }
        }
        
        return -1; 
    }
}