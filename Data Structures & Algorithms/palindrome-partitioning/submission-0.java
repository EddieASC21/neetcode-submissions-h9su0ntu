class Solution {
    public List<List<String>> partition(String s) {
        // list of list 
        List<List<String>> output = new ArrayList<>();

        // list to store partitions
        List<String> partition = new ArrayList<>();

        helper(s, output, partition, 0);

        return output;
    }

    // recursive helper function for backtracking
    private void helper(String s, List<List<String>> output, List<String> partition, int index){
        // base case

        // if our index is out of bounds, we add our current partition
        if(index >= s.length()){
            output.add(new ArrayList<>(partition));
            return;
        }

        // we iterate over all the other characters in our string, this is our substring
        for(int j = index; j < s.length(); j++){
            // we now want to check if our substring is a palidrome
            // we will check from our index up until j, to see if every possible substring is a palidrome
            if(isPalidrome(s.substring(index, j + 1))){
                // if it is a palidrome
                // to our partition, we add our string
                partition.add(s.substring(index, j + 1));
                // recursive function
                // we do j + 1 and not index + 1, as that is our next character
                helper(s, output, partition, j + 1);
                // we now backtrack
                // we remove the substring we just added
                partition.remove(partition.size() - 1);
            }
        }
    }

    // helper function to denote if substring is a palidrome
    private boolean isPalidrome(String substring){
        // we set the left and right pointer
        int left = 0, right = substring.length() - 1;

        while(left < right){
            // if the characters at the left and right pointers are not the same, it is not a palidrome
            if(substring.charAt(left) != substring.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}

/*
We are to return a list of list of strings

We are given a string s

we want to split s into substrings

we ensure that every substring is a palidrome

So we have an example:

s = "aab"

the output would be having a and b being a palidrome

with noting aa is also a palidrome

so we would have our output as [["a", "a", "b"], ["aa", "b"]]

An approach:

We can use backtracking to validate every substring if it is a palidrome

For our recursive case, we would check the substring from its index to the end if it is a palidrome and include it in the path 

Another approach:

We will use backtracking

We will create every single way we can partition the array

then we will check if every partition is a palidrome

if they do, we add it to our result list
*/
