class Solution {
    public int largestRectangleArea(int[] heights) {
        // we keep track of the max area found
        int maxArea = 0;
        // the stack will hold the indices of each height, this will help with finding the width
        Stack<Integer> stack = new Stack<>();

        // note we calculate all the remaining rectangles after the last bar was visited and if the stack is not empty
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length ? 0 : heights[i]);
            // if we find a height smaller than the one at the top of the stack then we must pop from the top as it can no longer be fully extended
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                // we take the height from the index of the top of the stack
                int height = heights[stack.pop()];
                // the width is then found by the distance from the current index i to the index of the next element in the stack after we have popped
                // if the stack is empty then the width is from the beginning of the array to i
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                // if a greater area is found we update our max area
                maxArea = Math.max(maxArea, height * width);
            }

            // we push the current index to the stack if the stack is empty or greater than the current top of the stack
            stack.push(i);
        }

        return maxArea;
        
    }
}
