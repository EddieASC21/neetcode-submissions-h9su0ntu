class Solution {
    public boolean isAnagram(String s, String t) {
        // finding the length of the strings
        int len1 = s.length();
        int len2 = t.length();
        
        //comparing the length as if not equal cannot be an anagram
        if(len1 != len2) return false;

        // store the strings as an array
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        // sorting the strings
        Arrays.sort(chS);
        Arrays.sort(chT);

        for(int i = 0; i < len1; i++){
            if(chS[i] != chT[i]) return false;
            
        }

        return true;

    }
}
