class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
        int arrows = 1; 
        int maxEnd= points[0][1]; 
        for(int i = 0; i < points.length; i++){
            int start = points[i][0];
            if(start > maxEnd) {
                arrows++;
                maxEnd = points[i][1]; 
            }  
        }
        return arrows; 
    }
}