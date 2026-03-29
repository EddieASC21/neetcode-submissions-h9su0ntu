class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        // mapping closing to opening brackets
        map.put(')', '(');
        map.put(']', '[');
        map.put('}','{');

        for(char c : s.toCharArray()){
            // we check if the current character is a closing bracket
            if(map.containsKey(c)){
                // we check that our stack is both not empty and the top of our stack is the matching opening bracket
                // if true we then pop from the stack as we have a valid pair
                if(!bracket.isEmpty() && map.get(c).equals(bracket.peek())) bracket.pop();
                else return false;
            }
            // we push the opening brackets onto the stack
            else bracket.push(c);
        }
        return bracket.isEmpty();
    }
}
