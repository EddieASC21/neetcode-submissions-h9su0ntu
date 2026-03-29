class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // store the indices of the temperatures
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            // we check is the current temperature is greater than that at the top of the stack
            // we then find the difference from the index of the previous day with the lower temperature and the current higher one
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) result[stack.peek()] = i - stack.pop();
            // we push the current's day index to our stack
            stack.push(i);
        }

        return result;  
    }
}
