class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int num : nums){
            // the error in this code is what happens first, we first check if it doesnt have
            // it and add it, when we should check if it does have have then add
            // if(!(map.contains(num))) map.add(num);
            // if(map.contains(num)) return true;
            if(map.contains(num)) return true;
            map.add(num);
        }
        return false;
    }
}
