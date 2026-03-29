class Solution {
    public int lengthOfLongestSubstring(String s) {
        // set to store all teh characters seen in the substring
        Set<Character> set = new HashSet<>();
        // the left index is the start of substring
        int left = 0, result = 0;

        // right index denotes how much we can expand our substring until we find a repeating character
        for(int right = 0; right < s.length(); right++){
            // if we find a repeating character/it is in our set, then we remove the character starting from the left pointer and increment our left pointer narrowing on substring, we continue while our substring has repeating characters
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            // after our current substring no longer contains repeating characters, we add the current character our right pointer is pointing at to the set
            set.add(s.charAt(right));
            // we determine the result by taking the index of the right pointer, where our substring ends, and subtracting from it the left pointer, the index of where our current substring begins and add 1 de to 0 index basing, we then take the max of our current substring length and the previous max result
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
