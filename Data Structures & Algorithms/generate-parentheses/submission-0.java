class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String combination, int open, int close, int m){
        if(combination.length() == m * 2){
            result.add(combination);
            return;
        }

        if(open < m) backtrack(result, combination + "(", open + 1, close, m);
        if(close < open) backtrack(result, combination + ")", open, close + 1, m);
    }
}
