class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : cpdomains) {
            int visits = Integer.parseInt(s.substring(0,  s.indexOf(" ")));
            String t = s.substring(s.indexOf(" ") + 1);
            for(int i = 0; i < t.length(); i++) {
                if(t.charAt(i) == '.') {
                    String temp = t.substring(i + 1);
                    map.put(temp, map.containsKey(temp) ? map.get(temp) + visits: visits);
                }
            }
            
            map.put(t, map.containsKey(t) ? map.get(t) + visits : visits);
        }
        ArrayList<String> ret = new ArrayList();
        
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            String s = e.getKey();
            int i = e.getValue();
            ret.add(Integer.toString(i) + " " + s);
        }
        return ret;
    }
}