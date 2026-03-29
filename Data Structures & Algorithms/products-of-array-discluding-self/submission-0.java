class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        // we set the first element in the array to one as there is no element to the left of the first element in the nums array
        result[0] = 1;

        // we now find all the products left to our current index
        for(int i = 1; i < n; i++) result[i] = result[i - 1] * nums[i - 1];

        // we set this as a tracker of our product of all elements to the right of our current index
        int right = 1;
        
        // we iterate over our result array with our left products 
        for(int i = n - 1; i >= 0; i--){
            // we multiply the products in the result array by the right product of our current index
            result[i] *= right;
            // we update our right product tracker
            right *= nums[i];
        }

        return result;
    }
}  
