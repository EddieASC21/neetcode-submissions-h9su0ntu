class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;

        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int partition = left;

        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                int temp = nums[partition];
                nums[partition] = nums[i];
                nums[i] = temp;
                partition++;
            }
        }

        int temp = nums[partition];
        nums[partition] = nums[right];
        nums[right] = temp;

        if(partition > k) return helper(nums, left, partition - 1, k);
        else if(partition < k) return helper(nums, partition + 1, right, k);
        else return nums[partition];
    }
}
