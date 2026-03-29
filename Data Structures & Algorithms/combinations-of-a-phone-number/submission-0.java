class Solution {
    public List<String> letterCombinations(String digits) {
        // we have the output
        List<String> output = new ArrayList<>();

        // we have our map to map our digits to its respective characters
        Map<Character, String> map = new HashMap<>(); 

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // we call our helper function only if our digit string given is not empty
        if(digits.length() != 0) helper(digits, output, map, 0, "");

        return output;
    }
    // recursive backtracking helper function
    private void helper(String digits, List<String> output, Map<Character, String> map, int index, String currentString){
        // base case

        // if our current string is the same length as digits, then this means we took every digit and mapped it to a character
        if(currentString.length() == digits.length()){
            output.add(currentString);
            return;
        }

        // we get the mapping string of our current character
        // we iterate over every character in the string
        for(char c : map.get(digits.charAt(index)).toCharArray()){
            // we make our recursive call
            // we increment our index as we move to the next digit
            // we add the character we are visiting to our string
            helper(digits, output, map, index + 1, currentString + c);
        }
    }
}

/*
We are to return a lisit of strings

we are given a string 

The string is made up of digits from 2 to 9

these digits is mapped to a set of characters such as a keypad

This digit can represent any of the characters it may map to

We want all the possible letter combinations given the digits given

An approach:

We would use a hashmap to map all the characters to its respective digit

We recursively then find all letter combinations

At each current digit 

We would try all letters mapped to it

add it to our combination

then we recurse to the next digit

we of course backtrack and remove once done with the combination

our base case can be that if our combination is the length of the digits, we can add it to our result

Another approach:

The amount of combinations we can have is 3 to the power of amount of digits in our string for digits not 7 or 9

so if we have "67", we would have 3 * 4, 12, combinations

We have a hashmap to match the digits to the characters
*/