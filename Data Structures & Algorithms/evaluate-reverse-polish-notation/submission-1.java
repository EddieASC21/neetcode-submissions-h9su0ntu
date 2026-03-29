class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String c : tokens){
            // if we are on a +, we add the previous two values
            if(c.equals("+")) stack.push(stack.pop() + stack.pop());
            // if subtraction then we must take the first popped subtracted from the second pop
            else if(c.equals("-")){
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            }
            // if we are on a *, we multiply the previous two values
            else if(c.equals("*")) stack.push(stack.pop() * stack.pop());
            // if division then we must take the first popped divided from the second pop
            else if(c.equals("/")){
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            }
            // if on a number we push it to the stack
            else stack.push(Integer.parseInt(c));
        }
        // our final answer is the final value in the stack
        return stack.pop();
    }
}
