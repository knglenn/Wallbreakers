class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                open.push(c);
            }
            else {
                if(!open.isEmpty()) {
                    char temp = open.pop();
                    if(temp == '('&& c != ')') {
                        return false; 
                    }
                    else if(temp == '{' && c!= '}') {
                        return false;
                    }
                    else if(temp == '[' && c!= ']') {
                        return false; 
                    }
                }
                else {
                    return false; 
                }
            }
        }
        return open.isEmpty(); 
    }
}