class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            // we check if nums is sorted
            // if the left pointer is less then the mid point then it is left sorted
            if(nums[left] <= nums[mid]){
                // more so if left sorted, we check if the target is in this side by comparing it to the mid value and if not then we know its not on this side 
                // or if target is less than the left pointer that points to the minimum value in this side, then we know its not on this side
                // given that it is not on this side as we have checked both conditions where only one has to be true, we know that its not on this side so we update the left pointer so we may check the right side 
                if(target > nums[mid] || target < nums[left]) left = mid + 1;
                // else if the target is on this side then we check this side by updating the right pointer
                else right = mid - 1;
            }
            // now if it is on the right side and right sorted
            else{
                // more so if right sorted, we check if the target is in this side by comparing it to the mid value and if not then we know its not on this side 
                // or if target is greater than the right pointer that points to the maximum value in this side, then we know its not on this side
                // given that it is not on this side as we have checked both conditions where only one has to be true, we know that its not on this side so we update the right pointer so we may check the left side 
                if(target < nums[mid] || target > nums[right]) right = mid - 1;
                else left = mid + 1;
            }
        }

        return -1;
    }
}
