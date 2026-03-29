class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, result = 0;
        while (left < right) {
            // we find the area from our current left and right pointer, where we take the width of our pointers and min height of the two pointers as no slanting
            int area = Math.min(heights[left], heights[right]) * (right - left);
            // as we iterate we update our contain to the max value we have seen
            result = Math.max(result, area);
            // we either increment our left pointer or decrement right pointer depending which pointer is pointing to the shorter bar
            if (heights[left] <= heights[right]) left++;
            else right--;
        }
        return result;
    }
}
