class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int[] parityArr = new int[A.length];
        int evenIndex = 0;
        int oddIndex = A.length -1;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                parityArr[evenIndex] = A[i];
                evenIndex++;
            }
            else {
                parityArr[oddIndex] = A[i];
                oddIndex --; 
            }
        }
        
        return parityArr; 
    }
}