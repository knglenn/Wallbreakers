class Solution {
    public String countOfAtoms(String formula) {
        Stack<Integer> s = new Stack();
        int multiple = 1; 
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for(int i = formula.length() -1; i >= 0; i--) {
            if(Character.isDigit(formula.charAt(i)) ) {
                StringBuilder sb = new StringBuilder();
                String num = findNumber(i, formula, sb);
                
                if(formula.charAt(i - num.length()) == ')') {
                    multiple*= Integer.parseInt(num);
                    s.push(Integer.parseInt(num));  
                    i -= num.length();
                }
                else {
                    String element = findElement(i - num.length(), formula);
                    map.put(element, map.getOrDefault(element, 0) + (Integer.parseInt(num) * multiple));
                    i = i - num.length() - element.length() + 1; 
                }
            }
            else if(formula.charAt(i) == '(' && !s.isEmpty()) {
                multiple /= s.pop();
            }
            
            else if( Character.isLetter(formula.charAt(i))){
                String element = findElement(i, formula);
                if(element.length()== 2) {
                    i--;
                }
                map.put(element, map.getOrDefault(element, 0) + multiple);
            }
        }

        StringBuilder res = new StringBuilder();
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            String k = e.getKey();
            int v = e.getValue();
            res.append(v > 1 ? k + v : k);
        }
        return res.toString(); 
    }
    
    public String findElement(int i , String s) {
        StringBuilder sb = new StringBuilder();
        
        if(Character.isUpperCase(s.charAt(i))) {
            sb.append(s.charAt(i));
        }
        else  {
            sb.append(s.charAt(i - 1)).append(s.charAt(i));
        }
        return sb.toString(); 
    }
    
    public String findNumber(int i, String s, StringBuilder sb) {
        if(Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            return findNumber(i -1, s, sb);
        }
        return sb.reverse().toString();
    }
}