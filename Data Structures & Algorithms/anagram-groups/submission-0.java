class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to group the anagrams
        Map<String, List<String>> result = new HashMap<>();

        for(String s : strs){
            // set an array to keep track of count such as from a to z
            int[] count = new int[26];

            // within our array we take the ascii value
            // we subtract our character from a (value of a)
            // so b - a -> 81 - 80 = 1 and we know we have a b
            for(char c : s.toCharArray()) count[c - 'a'] ++;

            // we now add these values to our map to group
            // we make our count array to its repective word
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
