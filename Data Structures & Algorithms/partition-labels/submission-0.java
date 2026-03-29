class Solution {
    public List<Integer> partitionLabels(String s) {
        // we have a hashmap where we keep track of the index of the last occurence of each character
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        
        List<Integer> result = new ArrayList<>();

        // we keep track of the size of the current partition
        // we also keep track of the furthest last index within this partition
        int len = 0, end = 0;

        // we will now iterate over the string
        for(int i = 0; i < s.length(); i++){
            // as we iterate through the string, we increment the size
            len++;
            // we update the end of our current partition if the last index of the current character is greater
            if(map.get(s.charAt(i)) > end) end = map.get(s.charAt(i));

            // we stop our partition when we reach the end of it
            if(i == end){
                // we add the current size to our result
                result.add(len);
                // we then reset size for the next partition
                len = 0;
            }
        }

        return result;
    }
}

/*
We are given a string

We are asked to return a list of integers

Description:

We are given a string with all lowercase english letters

We want to split the string into as many substrings as we can

We want to ensure though that each letter only appears in at most one substring

We want to return a list of integers

Where each integer represents the length of the substrings 

Where the substrings must be in the order they appear in the string

Example:

Input: s = "xyxxyzbzbbisl"

We note that x appears from index 0 to index 3

We note that in between these indeces appears y from index 1 to index 4

So from index 0 to 4, only x and y appear so a substring of length 5 can be made

from index 5 we have z which appears up until index 7

inbetween these indeces, we have b which appears until index 9

So from index 5 to 9, we have b and z and so we can add another length 5

from then we have 3 letters that only appear once so we can consider each letter as its own substring

So we add a 1 to the array 3 times

So our result is [5, 5, 1, 1, 1]

An Approach:

We note that each letter must be in the substring from when it appears to its final occurence

A valid partition must contain all the occurences of the letter that is contained in it

If not, then the letter will appear in different substrings

What we will do:

We will iterate through the string to record the last index each letter appears at

Then from iterating again, we maintain two variables

one variable where we keep track of the farthest last index of the letters in the current substring

a variable keeping track of the start index of the current substring

So that for each index i

We update the variable of the farthest last index with the maximum of itself and the index we are on the array we keep record of the indeces

if the index i is equal to that varaible, we can end the current substring

We then add the size of that substring to our output array list 

Where the size is the first array subtracted by the start variable plus 1

Then we will update start to be that previous index plus 1 to start with the next index

We then return the array list once we have finished iterating through the string

Another Approach:

We can use a hashmap to keep track of each character in the input string's index where it last occurs

We will keep track of the size of the current partition 

We will also keep track of the index of the end of our partition which is the greatest last index of the characters in the current partition

When our index is equal to our end variable, then we can add the size of this partition to our result

After this we reset size to be 0 for the next substring

Once we reach the end of the string, we return our result array list
*/