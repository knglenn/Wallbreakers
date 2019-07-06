class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        //array of lists
        ArrayList<Character>[] list = new ArrayList[s.length()];
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            char k = e.getKey();
            int v = e.getValue();
            if(list[v -1] == null) {
                ArrayList<Character> temp = new ArrayList();
                list[v -1] = temp;
            }
            list[v -1].add(k);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = list.length - 1; i >= 0; i--) {
            ArrayList<Character> current = list[i];
            if(current != null) {
                for(char c : current) {
                    int j = 0; 
                    while(j < i + 1) {
                        sb.append(c); 
                        j++;
                    }
                }
            }
        }
        return sb.toString();
    }
}