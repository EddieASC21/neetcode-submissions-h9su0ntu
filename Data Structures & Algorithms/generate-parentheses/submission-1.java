class Solution {
    public List<String> generateParenthesis(int n) {
        // store all the possible combinations
        List<String> result = new ArrayList<>();
        // we call our helper function
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // recursive helper function
    private void backtrack(List<String> result, String combination, int open, int close, int m){
        // base case
        // if our current string is 2 * n as n is pairs, then we have met the correct number of parentheses and add that to our result
        if(combination.length() == m * 2){
            result.add(combination);
            return;
        }

        // base case
        // if the number of opening parentheses is less than that of the value of n, then we can add an opening opening parenthesis to the string
        // we then can pass that in our recursive call where we add the opening parethesis and increment the value of open
        if(open < m) backtrack(result, combination + "(", open + 1, close, m);
        // if we having less closing parentheses then opening then we can add more closing parentheses to help complete our string
        // if we add a closing parenthesis, we then pass that in our recursive case where we add the closing parenthesis to the current string and increment the value of close
        if(close < open) backtrack(result, combination + ")", open, close + 1, m);
    }
}
