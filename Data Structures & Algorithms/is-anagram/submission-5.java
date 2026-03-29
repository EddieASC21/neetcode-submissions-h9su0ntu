class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'a']++;

        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i) - 'a']--;
            if(arr[t.charAt(i) - 'a'] < 0) return false;
        }
        
        return true;
    }
}

/*
so we are given two strings

we want to check if they are anagrams

so what we need to check is the frequency of each character is the same

also ensure the length of the two strings are equal

we want to return true if anagram else false

so what we will do is use i think its called counting sort

we take an array of size 26 to represent 26 characters in the alphabet 

lets say that the ascii value of 'a' is 80

so we iterate through the first string

for each character, we find the ascii difference to set that as its position in the array

for example if in the difference is 5 as 'a' is 80 and 'e' is 85, we would increment the value in that position in the array, so in this example index 4 as it 0 indexed based

so we continue this until the end of the array

now we have the populate array

we now iterate over the next string and do the same thing as previous but this time we decrement from the array

so then after we have iterated over the second string, if the array is not empty there is a discrepancy and so we return false else true
*/