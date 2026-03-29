class Solution {
    public String minWindow(String s, String t) {
        // we check if we have empty inputs and that if t is greater in length than s as then can't have t be a substring of s, so if any of this is true we return an empty string
        if(s.length() == 0 || t.length() == 0 || t.length() > s.length()) return "";

        // we create a map that will store the characters and their frequency in t
        Map<Character, Integer> tcount = new HashMap<>();
        // we create a map to store the characters and the frequencys in the current window of s
        Map<Character, Integer> windowcount = new HashMap<>();

        // we fill up the map of tcount as that will not change throughout the process
        for(char c : t.toCharArray()) tcount.put(c, tcount.getOrDefault(c, 0) + 1);

        // we start our sliding window
        // where want is the number of unique characters from t we want in our window in s
        // current then helps track the number of unique characters and their frequency that matches that in t within our window in s
        int want = tcount.size(), current = 0;
        // the result variable will help track and return our wanted indices of our wanted window
        int[] result = {-1, -1};
        // lenres will help provide the length of our wanted window
        int lenres = Integer.MAX_VALUE;

        int left = 0;
        // we expand the window by incrementing the right pointer
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            // when moving the right pointer to the right, we update our windowcount and each character 
            windowcount.put(c, windowcount.getOrDefault(c, 0) + 1);

            // we update current if the character and its frequency matches that in tcount
            if(tcount.containsKey(c) && windowcount.get(c).equals(tcount.get(c))) current++;

            // while we have a valid substring we will want to increment the left pointer to find the minimum valid window
            while(left <= right && want == current){
                c = s.charAt(left);

                // we update our result and its length if we find a new minimum valid window
                if(right - left + 1 < lenres){
                    lenres = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }

                // we update and decrease the frequency of the character that was found in our current left pointer and was leaving the window
                // we also update current if the now current window does not satisfies the condition
                windowcount.put(c, windowcount.get(c) - 1);
                if(tcount.containsKey(c) && windowcount.get(c) < tcount.get(c)) current--;
                left++;
            }

        }

        // if lenres is still equal to Integer.MAX_VALUE then we did not find an optimal window and so return an empty string else we return the substring of s from our left to tight pointer of our optimal window
        return lenres == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
