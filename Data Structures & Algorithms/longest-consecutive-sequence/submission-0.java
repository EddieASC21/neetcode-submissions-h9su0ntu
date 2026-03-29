class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // add all the numbers in array to the set for fast look up
        for(int num: nums) set.add(num);

        // tracking the longest sequence
        int longest = 0;

        for(int num : set){
            // we check if the number is start of a sequence
            // if the number - 1 exists that means it isn't the start of a sequence
            if(!set.contains(num - 1)){
                // as we now have the start of a sequence, we set the length to one
                int length = 1;
                // while the number + 1 and number + 2 and number + etc exists we keep adding to the length
                while(set.contains(num + length)) length++;
                // we now take our newest longest to be the max of our current longest and our current length
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
