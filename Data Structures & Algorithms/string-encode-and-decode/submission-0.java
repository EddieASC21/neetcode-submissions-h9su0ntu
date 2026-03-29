class Solution {

    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();
        
        // we go through each string
        // we add the length and delimeter to the string to help keep track when decoding
        for(String s : strs) enc.append(s.length()).append('#').append(s);

        return enc.toString();
    }

    public List<String> decode(String s) {
        List<String> dec = new ArrayList<>();

        // our pointer that begins to read the encoded string
        int i = 0;

        // we iterate over the encoded string
        while(i < s.length()){
            // we set our next pointer to keep track the length of our string
            int j = i;
            // we increment j as long as it is not on '#' as that would mean the value of its length has been completed
            // '#' is what seperates the length and the word itself
            while(s.charAt(j) != '#') j++;
            // once we find the numerical value length, we convert it into an integer
            int lengthOfS = Integer.valueOf(s.substring(i, j));
            // now we update our pointer to be pass '#' as that is where the string begins
            i = j + 1;
            // we then add the string to our list which has a length of lengthOfS which begins from i
            dec.add(s.substring(i, i + lengthOfS));
            // we update our pointer to the end of the string as we begin to decode the next string
            i += lengthOfS;
        }

        return dec;
    }
}
