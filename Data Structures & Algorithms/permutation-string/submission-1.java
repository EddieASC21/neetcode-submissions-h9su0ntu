class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // we check if s1 is greater in length than s2 because we can't have a premutation of longer string in a shorter one
        if(s1.length() > s2.length()) return false;

        // we initialize two arrays to store the frequencies of each character
        int[] s1count = new int[26], s2count = new int[26];

        // we fill in the frequencies of the characters in s1 and the initial window of s2 that is the size of s1
        for(int i = 0; i < s1.length(); i++){
            ++s1count[s1.charAt(i) - 'a'];
            ++s2count[s2.charAt(i) - 'a'];
        }

        // we check if the character frequencies match with the first window using the helper function, countsMatch, if they are equal that means we have a permutation and return true
        if(countsMatch(s1count, s2count)) return true;

        // we update and slide our window a character at a time from the end of our original window until the end of string of s2 unless we find a valid premutation
        for(int i = s1.length(); i < s2.length(); i++){
            // for each new character we newly encounter with when sliding our window, we increment it count frequency
            ++s2count[s2.charAt(i) - 'a'];
            // for each character that leaves the window, we decrement its count from the frequency
            --s2count[s2.charAt(i - s1.length()) - 'a'];

            // we then check if the current window frequency count is that equal to that of s1
            if(countsMatch(s1count, s2count)) return true;
        }

        return false;
    }

    // helper function to see if both frequency arrays are equal 
    private boolean countsMatch(int[] s1count, int[] s2count){
        // we iterate over both arrays and return false if there is a difference in count at any index
        for(int i = 0; i < 26; i++){
            if(s1count[i] != s2count[i]) return false;
        }

        return true;
    }
}
