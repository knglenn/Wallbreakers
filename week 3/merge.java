class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return intervals; 
        }
    
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        
        ArrayList<int[]> list = new ArrayList();
        
        int[] currentInterval = intervals[0]; 
        list.add(currentInterval);
        for(int[] row : intervals) {
            int prevEnd = currentInterval[1];
            int currentStart = row[0];
            
            if(currentStart <= prevEnd) {
                currentInterval[1] = Math.max(prevEnd, row[1]);
            }
            else {
                currentInterval = row; 
                list.add(currentInterval);
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}