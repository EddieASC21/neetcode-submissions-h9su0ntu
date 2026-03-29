class Solution {
    public int trap(int[] height) {
        // track wtaer trapped and the current left and right max
        int left = 0, right = height.length - 1, water = 0, leftMax = height[left], rightMax = height[right];

        while(left < right){
            if(leftMax < rightMax){
                // if the right pointer max is greater than that of the left we update the left pointer
                left++;
                // we then check if we need to update the left pointer's max to it is current value
                leftMax = Math.max(leftMax, height[left]);
                // we now calculate the water that is trapped by the bar
                water += leftMax - height[left];
            }
            else{
                // if the left pointer max is greater than that of the right we update the right pointer
                right--;
                // we then check if we need to update the right pointer's max to it is current value
                rightMax = Math.max(rightMax, height[right]);
                // we now calculate the water that is trapped by the bar
                water += rightMax - height[right];
            }
        }
        return water;
    }
}
