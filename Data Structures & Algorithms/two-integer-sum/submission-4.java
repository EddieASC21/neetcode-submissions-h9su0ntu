class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

/*
rather simple

what we must do is check is use a hashmap

as while we iterate through the array 

we want to see if the element we on can be added with any element seen to add to the target

we use a hashmap as we want to keep track of the index as thats what we must return 
*/