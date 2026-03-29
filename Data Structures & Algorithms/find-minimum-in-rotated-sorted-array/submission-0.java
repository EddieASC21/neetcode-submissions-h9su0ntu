class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            // if nums[mid] is greater than nums[right] then the smallest element must be to the right of mid
            if(nums[mid] > nums[right]) left = mid + 1;
            // else if nums[mid] is not greater than nums[right] then the smallest element will be to the left of mid
            else right = mid;
        }

        return nums[left];
    }
}
