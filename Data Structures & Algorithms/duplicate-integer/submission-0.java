class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a set
        HashSet<Integer> set = new HashSet<>();
        // iterating over the elements in the array
        for(int num : nums){
            // if the set has the value, that means has duplicate 
            if(set.contains(num)){
                return true;
            }
            // if set doesn't have value, then add to set
            set.add(num);
        }
        // no duplicates
        return false;
    }
}
