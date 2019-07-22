class Solution {
    int temp = 0; 
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<>();
        backtrack(ret, n);
        
        return ret; 
    }
    
    public void backtrack(ArrayList<Integer> list, int n) {
        if(n == 0) {
            list.add(temp);
        }
        else {
            backtrack(list, n-1);
            temp^=(1 << n -1);
            backtrack(list, n-1);
        }
    }
}