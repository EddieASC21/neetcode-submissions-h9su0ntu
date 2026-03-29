class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            // check before adding
            // because if we add and then check, we get a false positive
            if(set.contains(num)) return true;

            // now if not in set, we add to set
            set.add(num);
        }

        // reahed the end and no duplicates seen
        return false;
    }
}

/*
the question:

given an array of nums 

we want to return true if a value appears more than once 

else false

we use a hashset to keep track of see values

if not in the set, we add to set and continue

if we have seen the current element in the set, we return true

if we get to the end of the array and haven;t returned true means no duplicates seen so return false
*/