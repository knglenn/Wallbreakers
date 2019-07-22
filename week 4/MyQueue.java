class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> revStack; 
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        revStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return revStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(revStack.isEmpty()) {
            while(!stack.isEmpty()) {
                revStack.push(stack.pop());
            }
        }
        return revStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && revStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */