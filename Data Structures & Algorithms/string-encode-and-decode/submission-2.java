class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> lis = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;

            lis.add(str.substring(i, i + length));

            i += length;
        }

        return lis;
    }
}
