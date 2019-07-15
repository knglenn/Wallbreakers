class Solution {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> ret = new ArrayList();
        int lastAdded = -1; 
        int partitionEnd = 0; 
        HashSet<Character> checked = new HashSet();
        
        for(int i = 0; i < S.length(); i++) {
            if(checked.add(S.charAt(i))) {
                int index = S.lastIndexOf(S.charAt(i));
                if(index > partitionEnd) {
                    partitionEnd = index; 
                }
            }
            if(i == partitionEnd) {
                ret.add(lastAdded == -1 ? i + 1 : i - lastAdded);
                lastAdded = partitionEnd;
            }
        }
        return ret; 
    }
}