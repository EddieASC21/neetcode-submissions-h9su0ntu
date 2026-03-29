class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // we sort the array to help handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // iterate over each element to start our potential triplet solution
        for(int i = 0; i < nums.length; i++){
            // if the number is greater than 0 then we break as since sorterd, we cannot then sum to zero
            if(nums[i] > 0) break;
            // check if we are on duplicate
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // step up our pointers
            int left = i + 1, right = nums.length - 1;

            while(left < right){
                // we have initial triple and what it adds up to know how update the pointers
                int sum = nums[i] + nums[left] + nums[right];
                // if our sum is greater than zero we decrement the right pointer to be smaller
                if(sum > 0) right--;
                 // if our sum is left than zero we decrement the left pointer to be greater
                else if(sum < 0) left++; 
                else{
                    // now if our triplet is equal to zero we add it to our array
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // we move both the right and left pointer to look for new combinations
                    left++;
                    right--;
                    // we then check the next element is not a duplicate 
                    while(left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }

        return result;
    }
}
