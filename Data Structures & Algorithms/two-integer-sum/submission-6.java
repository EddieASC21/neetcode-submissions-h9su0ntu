class Solution {
    public int[] twoSum(int[] nums, int target) {
        // we will have hashmap to keep track of the indeces of the best possible solutions 
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // we find the difference between the target and current element
            int diff = target - nums[i];
            // we track this difference and keep track of the index to see if we can find the difference as we iterate through the array
            if(map.containsKey(diff)) return new int[]{map.get(diff), i};
            // we then check if the element we are on is in the map and if so we have found the difference and a valid solution
            map.put(nums[i], i);        
        }

        // if no solution found, we return -1 for both index to show not in array
        return new int[]{-1, -1};   
    }
}

/*
We will solve this using a hashmap

the way we will do this is by keeping track of the differences as we iterate through the array

so as we go through the array, we will subtract the element from the target and store that in the hashmap as the difference

so as we iterate through the array, we check if the current element is the difference

if it is the difference, then we return the index of this element and the difference's index 

if we can't find a valid solution, we return a 2 indexed array of -1 to show not in map
*/