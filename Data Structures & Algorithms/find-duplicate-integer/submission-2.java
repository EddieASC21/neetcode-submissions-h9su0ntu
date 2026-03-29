class Solution {
    public int findDuplicate(int[] nums) {
        // we set an array of booleans that is the length of the nums length
        boolean[] arr = new boolean[nums.length];
        for(int num : nums){
            // we see if the index in our array is marked as true as that means we have visted it and have marked it true meaning that this is our duplicate as we have seen it already and we will return this number/index
            if(arr[num]) return num;
            // if we have not seen this number before then we mark its index as true or in other words as visited
            arr[num] = true;
        }

        return -1;

    }
}