class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : candies) {
            set.add(i);
        }
        
        int numCandies = 0; 
        if(set.size() >= candies.length /2) {
            numCandies = candies.length /2;
        }
        else {
            numCandies = set.size();
        }
        
        return numCandies;
    }
}