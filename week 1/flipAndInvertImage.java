class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int middle = A[i].length /2;
            for(int j = 0; j < middle; j++) {
                int temp = 1 - A[i][j];
                A[i][j] =  1 - A[i][A[i].length -1 - j];
                A[i][A[i].length -1 - j] = temp; 
            }
            A[i][middle] = A[i].length % 2 == 0 ? A[i][middle] : 1 - A[i][middle];
           
        }
        return A; 
    }
}