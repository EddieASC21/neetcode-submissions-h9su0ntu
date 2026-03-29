class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map to track count of each number
        Map<Integer, Integer> count = new HashMap<>();
        // list to store the numbers by their frequencies
        // its size would be length of the array nums because worst case each number will have a "bucket"
        List<Integer>[] frequency = new List[nums.length + 1];

        // we create an array list for each bucket to represent worst case each frequency
        for(int i = 0; i < frequency.length; i++) frequency[i] = new ArrayList<>();

        // we now fill in the frequency map count
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        // we now add these numbers into our buckets
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) frequency[entry.getValue()].add(entry.getKey());

        // our array that will have the top k frequent elements
        int[] result = new int[k];

        int index = 0;

        // we go through the buckets in descending order 
        for(int i = frequency.length - 1; i > 0 && index < k; i--){
            for(int num : frequency[i]){
                // we add the number into our array result
                result[index++] = num;
                // we stop and return once we have collected k elements
                if(index == k) return result;
            }
        }
        return result;
    }
}