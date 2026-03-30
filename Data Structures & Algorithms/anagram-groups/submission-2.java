class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] hash = new char[26];

            for(char c : str.toCharArray()) hash[c - 'a']++;

            String key = new String(hash);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}


/*
reference anagrams on how to solve this 

you use the array as the key but the array is not hashable so we use a string 

we convert the array into a string

so then we use that string as the key and then we would have that mapped onto the value which is the words in which that array/string corresponds to
*/