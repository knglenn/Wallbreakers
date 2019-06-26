class Solution {
    public int[][] transpose(int[][] A) {
        int[][] transposed = new int[A[0].length][A.length];
        int column = 0; 
        for(int[] row : A) {
            for(int i = 0; i < row.length; i++) {
                transposed[i][column] = row[i];
            }
            column++;
        }
        return transposed; 
    }
}