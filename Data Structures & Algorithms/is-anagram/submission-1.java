class Solution {
    public boolean isAnagram(String s, String t) {

        // convert both strings to arrays to be sorted
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();

        // now we sort the arrays
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);

        // we will now check below if anagram

        // check is strings same length if not can't be anagram
        if(s.length() != t.length()) return false;

        // returns true if is anagram as would be same length and amount of characters
        return(Arrays.equals(sortedS, sortedT));
    }
}
