class Solution {
    public int characterReplacement(String s, int k) {
        // we create an array to keep track of the frequency of each character in the window
        int[] count = new int[26];
        // we keep track of the most frequent character in our window and keep track of the largest valid substring within our string
        int left = 0, maxfreq = 0, result = 0;

        // we expand the window by incrementing our right pointer
        for(int right = 0; right < s.length(); right++){
            // for each character we update its count in the count array and determine if the new incremented count is our most frequent character in the window 
            maxfreq = Math.max(maxfreq, ++count[s.charAt(right) - 'A']);

            // if the size of the window, right - left + 1, minus the max frequency is greater than k that means we have an invalid substring as we need more than k swaps to have a valid substring
            while(right - left + 1 - maxfreq > k){
                // if invalid substring then we increment our left pointer and decrement the count of the character at the left pointer until we have a valid substring
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // after we have a valid substring we update the size of the window to ensure our result is equal to the maximum length of all valid substrings we encountered 
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
