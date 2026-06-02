class Solution {
    public boolean isAnagram(String s, String t) {
        // we weren't guarenteed that the strings are same length
        // if they are not same length then they can never be same frequency
        // so we will return false
        if(s.length() != t.length()) return false;

        // we instantiate the 2 arrays to compare character and frequencies after 
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        // we will find the characters in string s and their frequencies
        // we find the character by subtracting via an ASCII value and using that as the index in the alphabet
        // we then grab that index and update its frequency in the array
        for(int i = 0; i < s.length(); i++) arrS[s.charAt(i) - 'a']++;
        for(int i = 0; i < s.length(); i++) arrT[t.charAt(i) - 'a']++;

        // we then compare the arrays to see if the characters and their frequency align 
        return Arrays.equals(arrS, arrT);
    }
}

/*
the way we will solve this by using two arrays, one for each string

the array will represent the ASCII value of each character

so for example the ASCII value will be the position in the array after we subtract it from 'a'

the way it works is that if 'a' has an ASCII value of 80

if we subtract a character from 'a', we would get its position in a 26 sized array representing the 26 character alphabet

so if we have character, 'b', and subtract it from 'a' then we have 'b' - 'a' which would be 81 - 80 

We would then get the value 1 and then that would be the position in the array 

so if we have a sized 26 element array, the increment of a value in the place of 'b', 2nd character of alphabet, then that means how may b's we have in the string

so then after we do that for both strings, then we will have the arrays with their character frequency and their characters

We can then compare the arrays and return true if they are equal else we return false
*/