class Solution {

    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();
        
        for(String s : strs) enc.append(s.length()).append('#').append(s);

        return enc.toString();
    }

    public List<String> decode(String s) {
        List<String> dec = new ArrayList<>();

        int i = 0;

        while(i < s.length()){
            int j = i;
          
            while(s.charAt(j) != '#') j++;
            int lengthOfS = Integer.valueOf(s.substring(i, j));
            i = j + 1;
            dec.add(s.substring(i, i + lengthOfS));
            i += lengthOfS;
        }

        return dec;
    }
}
