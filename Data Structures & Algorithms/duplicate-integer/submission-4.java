class Solution {
    public boolean hasDuplicate(int[] nums) {
        // set to keep track of elements seen
        Set<int> set = new HashSet<>();

        // iterate through all elements
        for(int num: nums){
            // if in the set, then we have seen this element
            // means we have a duplicate and we return true
            if(set.contains(num)) return true;

            // if not seen, we add to set and continue
            set.add(num);
        }

        // if we reach end of array, means we never return true and didn't find a duplicate
        // so we can return false
        return false;
    }
}

/*
I have this question and know how to solve this

the way you go about it is to think about sacrificing space complexity to save the time complexity

so we can use a data structure to help achieve a solution in linear time

so we can have a set so that we keep track of the elements we have seen so far while looking up in constant time

so we will add to the set as we iterate through the array

as we add, we will check if this element already exist in the set before we add it

if it exists then we will return true as we have already seen this element and so we have a duplicate

if we add to the set and reach the end of the array, then we can return false as that means we have no duplicates 
*/