class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // we must determine the minimum value to push to our minSTack by comparing the current value val and the top of our minStack
        // if min stack is empty then we use the current value
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
        
    }
    
    public void pop() {
        // we pop from both stacks so that minstack correctly keeps track of our minimum values
        stack.pop();
        minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        // our minimum value was always be the top of our minstack
        return minStack.peek();
    }
}
