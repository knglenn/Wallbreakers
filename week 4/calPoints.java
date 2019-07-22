class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int points = 0; 
        int secondLast = 0; 
        for(String str : ops) {
            if(str.equals("C")) {
                s.pop();
            }
            else if(str.equals("D")) {
                s.push(s.peek() * 2);
            }
            else if(str.equals("+")) {
                int temp = s.pop();
                int sum = temp + s.peek();
                s.push(temp);
                s.push(sum);
            }
            else {
                int temp = Integer.parseInt(str);
                s.push(temp);
            }
        }
        while(!s.isEmpty()) {
           points+=s.pop();
        }
        return points; 
    }
}